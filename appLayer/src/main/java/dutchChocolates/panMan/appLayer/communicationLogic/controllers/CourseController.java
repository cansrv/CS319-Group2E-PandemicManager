package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.*;
import dutchChocolates.panMan.appLayer.communicationLogic.services.CourseService;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.*;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {
    //Properties
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;


    //Constructors



    //Methods
    @PostMapping("/coursePopulator")
    @ResponseBody
    public String addCourse(@RequestBody String courseName){
        List<String> courseList = new ArrayList<>();
        JsonObject jsonLogin = new JsonParser().parse(courseName).getAsJsonObject();

        courseList.add(jsonLogin.get("course_name").getAsString());

        //TODO need to be successfully connected with the course services add method.
        return null;

    }


    @PostMapping("/sectionPopulator")
    @ResponseBody
    public String addSection(@RequestBody String sectionBody) {
        Boolean isOnline =   new JsonParser().parse(sectionBody).getAsJsonObject().get("is_online").getAsBoolean();
        Integer sectionNum = new JsonParser().parse(sectionBody).getAsJsonObject().get("section_number").getAsInt();
        String courseName =  new JsonParser().parse(sectionBody).getAsJsonObject().get("course_course_name").getAsString();
        Section section = new Section();
        section.setSectionNumber(sectionNum);
        section.setOnline(isOnline);
        Course course =new Course();
        course.setCourseName(courseName);
        section.setCourse(course);
        return courseService.addSection(isOnline, sectionNum, courseName);

    }

    @PostMapping("/getExam")
    @ResponseBody
    public String requestExam(@RequestBody Long id){
        Exam exam = (Exam) courseService.getExam(id);

        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
        return gson.toJson(exam);
    }

    @PostMapping("/createExam")
    @ResponseBody
    public String createExam(@RequestBody String examJson) throws ParseException {
        JsonObject jsonRepOfExam = new JsonParser().parse(examJson).getAsJsonObject();

        Long id = Long.valueOf(jsonRepOfExam.get("id").getAsString());

        String courseName = jsonRepOfExam.get("course").getAsString();
        Course course = courseService.getCourse("courseName");

        String instructorMail = jsonRepOfExam.get("instructorMail").getAsString();
        Instructor instructor = (Instructor) userService.getUser(instructorMail);

        JsonArray jsonParticipantArray = jsonRepOfExam.get("participants").getAsJsonArray();
        ArrayList<String> participantMailList = new ArrayList<String>();
        if(jsonParticipantArray != null){
            for(int i = 0; i < jsonParticipantArray.size(); i++){
                System.out.println(jsonParticipantArray.get(i).getAsString());
                participantMailList.add(jsonParticipantArray.get(i).getAsString());
            }
        }
        ArrayList<Student> participants = new ArrayList<Student>();
        for(String bilkentId : participantMailList){
            if(userService.searchUser(bilkentId) != null){
                participants.add((Student) userService.searchUser(bilkentId));
            }
        }
        Attendance attendance = new Attendance(participants);

        String dateStr = jsonRepOfExam.get("date").getAsString();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);

        Exam exam = new Exam();
        exam.setId(id);
        exam.setCourseCoordinator(instructor);
        exam.setSpareHour(false);
        exam.setAttendance(attendance);

        return courseService.setExam(exam);
    }

    @PostMapping("/deleteExam")
    @ResponseBody
    public String deleteExam(@RequestBody Long id){
        try{
            Exam exam = courseService.getExam(id);
            courseService.deleteExam(exam);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    @PostMapping("/getCourses")
    @ResponseBody
    @CrossOrigin
    public String getCourses(@RequestBody String mail){
        JsonObject jsonRepOfMail = new JsonParser().parse(mail).getAsJsonObject();

        Instructor instructor = (Instructor) userService.getUser(jsonRepOfMail.get("mail").getAsString());

        ArrayList<Course> courseList = (ArrayList<Course>) courseService.getCoursesOfInstructor(instructor);
        ArrayList<String> courseNameList = new ArrayList<String>();

        for(Course course : courseList){
            if(course.getCourseName() != null){
                courseNameList.add(course.getCourseName());
            }
        }

        return courseNameList.toString();

    }

    private Attendance attendanceParser(JsonObject jsonObject) {
        return null;
    }

    private Lecture lectureParser(JsonObject jsonObject) {
        return null;
    }

    private Exam examParser(JsonObject jsonObject) {

        return null;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
