import React from "react";
import {Link} from "react-router-dom";

export const Header = ({isConnected}) => {
    return (
        <div id="header3" >
            <nav className="navbar navbar-expend-lg bg-body-tertiary">


                <div className="col-12 col-md-4">
                    <Link to={"/"}>ENI-Encheres</Link>
                </div>



                <div className="col-12 col-md-8 d-flex flex-column flex-md-row justify-content-md-end align-items-md-center m-0">

                {isConnected ?
                    <>
                        <div className="text-lg-center text-left px-4">
                            <Link to={"/"}>Enchères</Link>
                        </div>


                        <div className="text-lg-center text-left px-4">
                            <Link to={"/vendre-un-article"}>Vendre un article</Link>
                        </div>


                        <div className="text-lg-center text-left px-4">
                            <Link to={"/mon-profil"}>Mon profil</Link>
                        </div>


                        <div className="text-lg-center text-left px-4">
                            <Link to={"/"}>Déconnexion</Link>
                        </div>
                    </>
                :
                    <>
                        <div className="d-flex align-items-center col-md-3 ms-4">
                            <Link to={"/creer-compte"}>S'inscrire</Link>
                        </div>


                        <div className="d-flex align-items-center col-md-3 ms-4">
                            <Link to={"/connection"}>Se connecter</Link>
                        </div>
                    </>
                }

                </div>
            </nav>
        </div>
    )
}