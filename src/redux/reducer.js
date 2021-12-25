const reducer =  (state,action) =>{
    if (action.type === "LOGIN") {
        return {
            ...action.payload,
            ...state
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