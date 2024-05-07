import { useState } from "react";
import EmpList from "./EmpList";
import AddEmp from "./AddEmp";
import { useSelector, useStore } from "react-redux";
import EmpSlice from "../redux/EmpSlice";

const Employee = () => {

    // const dataFromStore = useStore(() => { });
    // const dataFromStore = useStore((store) => { return store.empObj; });
    const dataFromStore = useSelector(EmpSlice.empSlice.emp.firstName);
    console.log(dataFromStore);
    return (
        <>
            <>
                <p>Data received from store</p>
                <p>{dataFromStore && dataFromStore.firstName}  </p>
            </>
            <h1>Employee Component</h1>
            <AddEmp />
            <EmpList />
        </>
    );
};

export default Employee;
// const Employee = () => {
//     const [name , setName] = useState();
//     const handleNameInput = (evt) => {
//         console.log(evt.target.value);
//         //name = evt.target.value;
//         setName(evt.target.value);
//     }
//     return(
//         <>
//             <h1>Employee Component</h1>
//             {/* <p>Employee name is {name}</p>
//             <form>
//                 <input type="text" name="name" value={name} onChange={handleNameInput}></input>
//             </form> */}
//             <EmpList/>
//             <AddEmp/>
//         </>
//     )
// }

// export default Employee;