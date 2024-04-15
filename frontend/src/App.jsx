import { Routes, Route, BrowserRouter } from "react-router-dom"
import Layout from "./views/Layout.jsx"
import {Connection} from "./views/Connection.jsx";
import {Header} from "./views/Header.jsx";
import Home from "./Home.jsx";
import './App.css'


export const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route
                    path="/"
                    element={<Layout title="home" header={<Header />} main={<Home/>} />}
                />
                <Route
                    path="/connection"
                    element={<Layout title="connection" header={<Header />} main={<Connection/>} />}
                />
            </Routes>
        </BrowserRouter>
    )
}