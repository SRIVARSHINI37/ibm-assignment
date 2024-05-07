import React, { useState } from 'react';
import axios from 'axios';

const Profile = () => {
    const [empId, setEmpId] = useState('');
    const [empData, setEmpData] = useState(null);
    const [error, setError] = useState(null);

    const handleChange = (event) => {
        setEmpId(event.target.value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        // Fetch data from backend using empId
        axios.get(`http://localhost:9090/emp/get-emp-by-id/${empId}`)
            .then((response) => {
                setEmpData(response.data);
                setError(null);
            })
            .catch((error) => {
                setError('Error fetching employee data. Please try again.');
                console.error('Error fetching employee data:', error);
                setEmpData(null);
            });
    };

    return (
        <>
            <h1>User Profile</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Enter Employee ID:
                    <input type="text" name="empid" value={empId} onChange={handleChange} />
                </label>
                <button type="submit">Fetch Data</button>
            </form>

            {empData && (
                <div>
                    <h2>Employee Details</h2>
                    <p>Employee ID: {empData.empid}</p>
                    <p>Name: {empData.name}</p>
                    <p>Email: {empData.email}</p>
                    <p>Aadhar: {empData.aadhaar}</p>
                    <p>Salary: {empData.salary}</p>
                    {/* Add more fields as needed */}
                </div>
            )}

            {error && <p>{error}</p>}
        </>
    );
};

export default Profile;
