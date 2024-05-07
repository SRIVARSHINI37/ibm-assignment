import { useState } from "react";
import { useNavigate } from "react-router-dom";


const Login = ({ setLoginStatus }) => {
    const [loginData, setLoginData] = useState({ username: '', password: '' });
    const [afterLoginMessage, setAfterLoginMessage] = useState('');
    const navigate = useNavigate();

    const handleLoginInput = (evt) => {
        console.log(evt.target.value);
        console.log(loginData);
        setLoginData({
            ...loginData,//
            [evt.target.name]: evt.target.value
            
        });
    };

    // sonu sonu 

    const handleLoginSubmit = (evt) => {
        evt.preventDefault();
        if (loginData.username === 'varshini' && loginData.password === 'varshini') {
            setAfterLoginMessage(`Hi ${loginData.username}! You've logged in successfully!`);
            setLoginData({ username: '', password: '' });
            alert(`Hi ${loginData.username}! You've logged in successfully!`);
            setLoginStatus(true);
            navigate('/home');
            
        } else {
            setAfterLoginMessage(`Invalid credentials!`);
            alert(`Invalid credentials!`);
            setLoginData({ username: '', password: '' });
        }

    };
    return(
        <>
            <h1>Login Component</h1>
            <p>Login here</p>
            <form onSubmit={handleLoginSubmit}>
                <input type="text" name="username" value={loginData.username} onChange={handleLoginInput}></input>
                <input type="password" name="password" value={loginData.password} onChange={handleLoginInput}></input>
                <input type="submit" value="login"></input>
            </form>
            <>
                <p>{afterLoginMessage && afterLoginMessage} </p>
            </>
        </>
    )
}

export default Login;