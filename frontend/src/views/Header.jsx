import React from "react";
export const Header = () => {
    return (
        <div id="header3" >
            <nav className="row bg-white fixed-top p-3">


                <div className="col-12 col-md-4">
                    <a href="/" className="logo fs-4">ENI-Encheres</a>
                </div>



                <div className="col-12 col-md-8 d-flex flex-column flex-md-row justify-content-md-end align-items-md-center m-0">


                    <div className="d-flex align-items-center col-md-3 ms-4">
                        <a className="text-center fs-5" href="/">S'inscrire</a>
                    </div>


                    <div className="d-flex align-items-center col-md-3 ms-4">
                        <a className="text-center fs-5" style="white-space: nowrap;" href="/">Se connecter</a>
                    </div>


                    <div className="text-lg-center text-left px-4">
                        <a className="fs-5" href="/">Enchères</a>
                    </div>


                    <div className="text-lg-center text-left px-4">
                        <a className="fs-5" href="/">Vendre un article</a>
                    </div>


                    <div className="text-lg-center text-left px-4">
                        <a className="fs-5" href="/">Mon profil</a>
                    </div>


                    <div className="text-lg-center text-left px-4">
                        <a className="fs-5" style="white-space: nowrap;" href="/">Déconnexion</a>
                    </div>
                </div>
            </nav>
        </div>
    )
}