// steps in using redux store - 

// install libraries 
// create store 
// provide store to the app  
// create slices 
// send data to store 
// receive data from store 

import { configureStore } from "@reduxjs/toolkit";

import EmpReducer from './EmpSlice';

// const store = configureStore({});

const store = configureStore({
    reducer: {
        empObj: EmpReducer
        // more slices  
    }
});


export default store;