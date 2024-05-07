import { createSlice } from "@reduxjs/toolkit";

const empSlice = createSlice({
    name: 'emp',
    initialState : { 
        empObj: {firstName: 'Sonu', salary: 10.50}  
    },
    reducers : { // more methods 
        setEmpObj : (state, action) => {
            console.log(action.payload);
            state.empObj = action.payload;
        }
    }
});
export default empSlice.reducer;

export const {setEmpObj} = empSlice.actions;