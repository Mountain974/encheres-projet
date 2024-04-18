import React from "react";

export const Connection = () => {
    return (
        <div className="container-fluid">

            <div className="row title d-flex justify-content-center mb-4 shadow-lg p-3 mb-5">
                <div className="col-auto mt-5">
                    <h1 className="text-white text-center py-3">Connexion</h1>
                </div>
            </div>

            <div className="row d-flex justify-content-center mt-5">
                <div className="col-md-5 offset-md-7 mx-auto">
                    <form>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto text-md-end">
                                <label htmlFor="identifiant" className="fs-4">Identifiant</label>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                <input id="identifiant" type="text"
                                       className="form-control fs-5" name="identifiant"
                                       required autoComplete="identifiant" value="identifiant" autoFocus/>
                            </div>
                        </div>


                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto text-md-end">
                                <label for="password" className="fs-4">Mot de passe</label>
                            </div>

                            <div className="col-7 offest-5 mx-auto">
                                <input id="password" type="password"
                                       className="form-control" name="password" required
                                       autoComplete="current-password" value="password" />
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mx-auto my-5">

                            <div className="col-5 offset-7 mx-auto d-flex justify-content-end">
                                <button type="submit" className="btn btn-secondary btn-lg button">Connexion</button>
                            </div>

                            <div className="col-6 offest-6 mx-auto">
                                <div className="row d-flex justify-content-center mb-2">
                                    <label>
                                        <input type="checkbox" name="remember-me" id="remember-me" value="rememberMe" />
                                            Se souvenir de moi
                                    </label>
                                </div>
                                <div className="row d-flex justify-content-center">
                                    <a href="/mot-de-passe-oublie">Mot de passe oublié</a>
                                </div>
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mx-auto">
                            <div className="col-md-5 offset-md-7 mx-auto w-100">
                                <button type="submit" className="btn btn-secondary btn_confirm btn-lg w-100 button">Créer un compte</button>
                            </div>
                        </div>

                    </form>
                </div>

            </div>

        </div>
    )
}