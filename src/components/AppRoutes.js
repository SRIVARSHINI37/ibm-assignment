import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./Home";
import Parent from "./Parent";
import Page404 from "./Page404";
import Login from "./Login";
import Employee from "./Employee";
import Menubar from "./Menubar";
import Logout from "./Logout";
import Profile from "./Profile";
import Register from "./Register";
import { useState } from "react";

const AppRoutes = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const updateLoginStatus = (status) => {
        console.log(status);
        setIsLoggedIn(status);
    };

    if (isLoggedIn) {
        return (
            <BrowserRouter>
                <Menubar loginStatus={isLoggedIn} />
                <Routes>
                    <Route path="/home" element={<Home />} />
                    <Route path="/emp" element={<Employee />} />
                    <Route path="/parent" element={<Parent />} />
                    <Route path="/logout" element={<Logout setLoginStatus={updateLoginStatus} />} />
                    <Route path="/profile" element={<Profile />} />
                    <Route exact path="/" element={<Home />} />
                    <Route path="*" element={<Page404 loginStatus={isLoggedIn} />} />
                </Routes>
            </BrowserRouter>
        );
    } else {
        return (
            <BrowserRouter>
                <Menubar loginStatus={isLoggedIn}/>
                <Routes>
                    <Route path="home" element={<Home />} />
                    <Route path="login" element={<Login setLoginStatus={updateLoginStatus} />} />
                    <Route path="register" element={<Register />} />
                    <Route exact path="/" element={<Home />} />
                    <Route path="*" element={<Page404 loginStatus={isLoggedIn} />} />
                </Routes>
            </BrowserRouter>
        );
    }
};

export default AppRoutes;
