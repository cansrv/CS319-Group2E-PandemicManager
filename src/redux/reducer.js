const reducer =  (state,action) =>{
    if (action.type === "LOGIN") {
        return {
            ...state,
            ...action.payload,
            
        }
    }
    if (action.type === "ADD_NEW_GROUP") {
        var newGroups = [];
        if (!action.payload.group.length) {
            newGroups = [...state.groups, action.payload.group];
        }
        return {
            ...state,
            groups: newGroups,
        }
    }
    if (action.type === "REMOVE_GROUP") {
        var newGroups = action.payload.group;
        return {
            ...state,
            groups: newGroups,
        }
    }
    if (action.type === "ADD_NEW_EXAM") {
        var newExams = [];
        if (!action.payload.exam.length) {
            newExams = [...state.exams, action.payload.exam];
        }
        return {
            ...state,
            exams: newExams,
        }
    }
    if (action.type === "REMOVE_EXAM") {
        var newExams = action.payload.exam;
        return {
            ...state,
            exams: newExams,
        }
    }
    if (action.type === "EDIT_HES_CODE") {
        return {
            ...state,
            HEScode: action.payload.HEScode,
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