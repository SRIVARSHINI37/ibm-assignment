import axios from "axios";
import { useEffect, useState } from "react"


const EmpList = () => {
    const [empList , setEmpList] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:9090/emp/get-all-emps')
        .then((res)=>{
            console.log(res);
            setEmpList(res.data);
        })
    } , []);

    return(
        <>
            <h2>Employee List</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Aadhar</th>
                        <th>salary</th>
                    </tr>
                </thead>
                <tbody>
                    {empList.map(emp =>
                        <tr key={emp.empid}>
                            <td>{emp.empid}</td>
                            <td>{emp.name}</td>
                            <td>{emp.email}</td>
                            <td>{emp.aadhaar}</td>
                            <td>{emp.salary}</td>
                        </tr>
                    )}
                </tbody>
            </table>

        </>
    )
}
export default EmpList;