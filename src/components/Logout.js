import { useNavigate } from "react-router-dom";

const Logout = ({ setLoginStatus }) => {
const navigate = useNavigate();

    const handleLogout = () => {
        setLoginStatus(false); // Update login status to false
        navigate('/login'); // Redirect to the login page
    };

    return (
        <div>
            <h1>Logout</h1>
            <button onClick={handleLogout}>Logout</button>
        </div>
    );
};


export default Logout;