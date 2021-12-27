import courses from "../components/courseData";

const reducer = (state, action) => {
    if(action.type === "LOGIN") {
        // var theGroups = [...action.payload.groupsCreated, ...action.payload.groupsParticipated]
        var theGroups = action.payload.groupsParticipated
        var theNameParsed = action.payload.fullName.split(" ")
        var theName = theNameParsed[0]
        var theSurname = theNameParsed[theNameParsed.length - 1]
        var theHEScode = action.payload.covidInformationCard.hesCodes[0]
        var theId = action.payload.username.substring(0, 8)
        var theTests = action.payload.covidInformationCard.tests
        var theAllowance = true
        var theCovidStatus = action.payload.covidInformationCard.covidStatus
        if (action.payload.covidInformationCard.covidStatus === "Risky" || action.payload.covidInformationCard.covidStatus === "Positive") {
            theAllowance = false
        }
        
        return {
            ...state,
            ...action.payload,
            loggedIn: true,
            groups: theGroups,
            name: theName,
            surname: theSurname,
            HEScode: theHEScode,
            id: theId,
            tests: theTests,
            isAllowedOnCampus: theAllowance,
            covidStatus: theCovidStatus,
        }
    }
    /*if (action.type === "LOGIN") {
        return {
            ...state,
            ...action.payload,
            loggedIn: true
        }
    }*/
    if (action.type === "LOGOUT") {
        return {
            ...state,
            loggedIn: false,
            name: "",
            surname: "",
            id: "",
            accountType: "",
            HEScode: "",
            groups: [],
            exams: [],
            attendance: [],
            coursesThaught: [],
            courses: [],
            email: "",
            isCovid: false,
            tests: [],
            isolationStartDate: "",
            isoEndDate: "",
            vaccinated: false,
            recovered: false,
            negativeTest: false,
            exams: [],
            isAllowedOnCampus: true,
            weeklyReport: []
        }
    }
    if(action.type === "ADD_NEW_GROUP") {
        var newGroups = [];
        if(!action.payload.group.length) {
            newGroups = [...state.groups, action.payload.group];
        }
        return {
            ...state,
            groups: newGroups,
        }
    }
    if(action.type === "FETCH_COURSES") {
        return {
            ...state,
            courses: action.payload,
        }
    }

    if(action.type === "REMOVE_GROUP") {
        var newGroups = action.payload.group;
        return {
            ...state,
            groups: newGroups,
        }
    }
    if(action.type === "ADD_NEW_EXAM") {
        var newExams = [];
        if(!action.payload.exam.length) {
            newExams = [...state.exams, action.payload.exam];
        }
        return {
            ...state,
            exams: newExams,
        }
    }
    if(action.type === "REMOVE_EXAM") {
        var newExams = action.payload.exam;
        return {
            ...state,
            exams: newExams,
        }
    }
    if(action.type === "EDIT_HES_CODE") {
        return {
            ...state,
            HEScode: action.payload.HEScode,
        }
    }
    if(action.type === "MARK_SELF_RISKY") {
        const d = new Date();
        let time = d.getTime();
        let newTime = time + 1209600000;
        time = new Date(time)
        newTime = new Date(newTime);
        newTime = String(newTime.toDateString())
        time = String(time.toDateString())

        return {
            ...state,
            isCovid: true,
            isolationStartDate: time,
            isoEndDate: newTime
        }
    }
    if(action.type === "SWITCH_COURSE_TYPE") {
        var theIndex = courses.findIndex((item => (item.name === action.payload.course.name && (item.section === action.payload.course.section))))
        console.log(theIndex)
        console.log(action.payload.course)
        var newArray = courses
        var theType = newArray[theIndex].type
        if (theType === "Online") {
            newArray[theIndex].type = "Face to Face"
        }
        else {
            newArray[theIndex].type = "Online"
        }

        console.log(newArray)
        return {
            ...state,
            courses: Array(...newArray)
        }
    }
    return state;
}

{/*
    if (action.type === "ASSIGN_COMPANY_DATA") {
        const sortedCompanies = action.payload.companies.sort((first,second) => {
            return first.name.localeCompare(second.name);
        });

        return {
            ...state,
            companies: sortedCompanies,
            filteredCompaniesBySearchBar: action.payload.companies
        }
    }
*/}
export default reducer;