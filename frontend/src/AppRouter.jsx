import { Routes, Route, BrowserRouter } from "react-router-dom"
import Layout from "./views/Layout.jsx"
import {Connection} from "./views/Connection.jsx";
import {Header} from "./views/Header.jsx";
import Hello from "./hello.jsx";


export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route
                    path="/"
                    element={<Hello/>}
                />
                <Route
                    path="/connection"
                    element={<Layout title="connection" header={<Header />} main={<Connection/>} />}
                />
            </Routes>
        </BrowserRouter>
    )
}