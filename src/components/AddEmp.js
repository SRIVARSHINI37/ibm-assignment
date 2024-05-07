import React, { useState } from "react";
import axios from "axios";

const AddEmp = () => {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        aadhaar: '',
        salary: ''
    });
    const [errors, setErrors] = useState({});
    const handleChange = (evt) => {
       setFormData({
        ...formData,
        [evt.target.name] : evt.target.value
       });
       
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validateForm()) {
            axios.post('http://localhost:9090/emp/add-emp', formData)
                .then((res) => {
                    console.log(res.data);
                    alert('Employee added successfully!');
                })
                .catch((error) => {
                    console.error('Error adding employee:', error);
                    alert('Error adding employee. Please try again later.');
                });
        }
    };

    const validateForm = () => {
        let errors = {};
        let isValid = true;

        if(formData.name.length<3 || formData.name.length>15){
            errors.name = 'Name should be between 4 to 15 characters'
            isValid = false;
        }
        // Validate Aadhaar
        if (!/^\d{12}$/.test(formData.aadhaar)) {
            errors.aadhaar = 'Aadhaar must be a 12-digit number';
            isValid = false;
        }

        // Validate Email
        if (!/\S+@\S+\.\S+/.test(formData.email)) {
            errors.email = 'Invalid email address';
            isValid = false;
        }
        if((formData.salary)<0){
            errors.salary = 'Salary cant be negative';
            isValid = false;
        }
        setErrors(errors);
        return isValid;
    };

    return (
        <>
            <h2>Add Employee</h2>
           
            <form onSubmit={handleSubmit}>
                <label>
                    Name:
                    <input type="text" name="name" value={formData.name} onChange={handleChange} required autoFocus/>
                </label>
                <br/>
                <span style={{ color: 'red' }}>{errors.name}</span>
                <br />
                <label>
                    Email:
                    <input type="email" name="email" value={formData.email} onChange={handleChange} required/>
                </label>
                <br />
                <span style={{ color: 'red' }}>{errors.email}</span>
                <br />
                <label>
                    Aadhaar:
                    <input type="text" name="aadhaar" value={formData.aadhaar} onChange={handleChange} required/>
                </label>
                <br />
                <span style={{ color: 'red' }}>{errors.aadhaar}</span>
                <br />
                <label>
                    Salary:
                    <input type="text" name="salary" value={formData.salary} onChange={handleChange} required/>
                </label>
                <br />
                <span style={{ color: 'red' }}>{errors.salary}</span>
                <br />
                <button type="submit">Add Employee</button>
            </form>
        </>
    );
};

export default AddEmp;
