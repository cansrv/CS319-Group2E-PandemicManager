const reducer =  (state,action) =>{
    if (action.type === "LOGIN") {
        return {
            ...action.payload,
            ...state
        }
    }
    if (action.type === "LOGIN") {
        return {
            ...action.payload,
            ...state
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