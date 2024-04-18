import { Routes, Route, BrowserRouter } from "react-router-dom"
import Layout from "./fragments/Layout.jsx"
import {Header} from "./fragments/Header.jsx";
import {Encherir} from "./pages/Encherir.jsx";
import Home from "./pages/Home.jsx";
import {Profil} from "./fragments/Profil.jsx";
import {MonProfil} from "./pages/MonProfil.jsx";
import {CreerCompte} from "./pages/CreerCompte.jsx";
import {ModifierProfil} from "./pages/ModifierProfil.jsx";
import {Acquisition} from "./pages/Acquisition.jsx";
import {Connection} from "./pages/Connection.jsx";
import {VendreUnArticle} from "./pages/VendreUnArticle.jsx";
import {EncheresNonCommencees} from "./pages/EncheresNonCommencees.jsx";
import {DetailVente} from "./pages/DetailVente.jsx"
import MesVentes from "./pages/MesVentes.jsx";
import './App.css'

export const App = () => {
    //déterminé si l'utilisateur est connecté
    const isConnected = true
    return (
        <BrowserRouter>
            <Routes>
                <Route
                    path="/"
                    element={<Layout title="home" header={<Header isConnected={isConnected} />} main={<Home isConnected />} />}
                />
                <Route
                    path="/connection"
                    element={<Layout title="Connection" header={<Header isConnected={isConnected} />} main={<Connection />} />}
                />
                <Route
                    path="/creer-compte"
                    element={<Layout title="Créer un compte" header={<Header isConnected={isConnected} />} main={<CreerCompte />} />}
                />
                <Route
                    path="/liste-enchere"
                    element={<Layout title="connection" header={<Header isConnected={isConnected} />} main={<Home />} />}
                />
                <Route
                    path="/mes-ventes"
                    element={<Layout title="connection" header={<Header isConnected={isConnected} />} main={<MesVentes />} />}
                />
                <Route
                    path="/profil/:pseudo"
                    element={<Layout title="Profil" header={<Header isConnected={isConnected} />} main={<Profil />} />}
                />
                <Route
                    path="/mon-profil"
                    element={<Layout title="Mon profil" header={<Header isConnected={isConnected} />} main={<MonProfil />} />}
                />
                <Route
                    path="/modifier-profil"
                    element={<Layout title="Modifier mon profil" header={<Header isConnected={isConnected} />} main={<ModifierProfil />} />}
                />
                <Route
                    path="/vendre-un-article"
                    element={<Layout title="Nouvelle vente" header={<Header isConnected={isConnected} />} main={<VendreUnArticle />} />}
                />
                <Route
                    path="/enchere-non-commencee"
                    element={<Layout title="Enchere non commencée" header={<Header isConnected={isConnected} />} main={<EncheresNonCommencees />} />}
                />
                <Route
                    path="/encherir/:noArticle"
                    element={<Layout title="encherir" header={<Header isConnected={isConnected} />} main={<Encherir />} />}
                />
                <Route
                    path="/acquisition"
                    element={<Layout title="acquisition" header={<Header isConnected={isConnected} />} main={<Acquisition />} />}
                />
                <Route
                    path="/detail-ma-vente-fin-enchere"
                    element={<Layout title="detail vente fin enchere" header={<Header isConnected={isConnected} />} main={<DetailVente />} />}
                />
            </Routes>
        </BrowserRouter>
    )
}