import React from "react";

export const Compte = ({utilisateur, isEdit}) => {
    return (
        <div className="row d-flex justify-content-center mt-5">
                <div className="col-md-5 offset-md-7 mx-auto">
                    <form>
                        <div className="row form-group mx-auto">
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="pseudo" className="fs-4">Pseudo :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="pseudo" type="text" className="form-control fs-5" name="pseudo"
                                               required autoComplete="pseudo" autoFocus value={utilisateur?.pseudo}/>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="nom" className="fs-4">Nom :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="nom" type="text" className="form-control fs-5" name="nom" required
                                               autoComplete="nom" autoFocus value={utilisateur?.nom}/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row form-group mx-auto">
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="prenom" className="fs-4">Prénom :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="prenom" type="text" className="form-control fs-5" name="prenom"
                                               required autoComplete="prenom" autoFocus value={utilisateur?.prenom}/>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="email" className="fs-4">Email :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="email" type="email" className="form-control fs-5" name="email"
                                               required autoComplete="email" autoFocus value={utilisateur?.email}/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row form-group mx-auto">
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="telephone" className="fs-4">Téléphone :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="telephone" type="text" className="form-control fs-5" name="telephone"
                                               required autoComplete="telephone" autoFocus
                                               value={utilisateur?.telephone}/>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="rue" className="fs-4">Rue :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="rue" type="text" className="form-control fs-5" name="rue" required
                                               autoComplete="rue" autoFocus value={utilisateur?.rue}/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row form-group mx-auto">
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="cp" className="fs-4">Code postal :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="cp" type="text" className="form-control fs-5" name="cp" required
                                               autoComplete="cp" autoFocus value={utilisateur?.codePostal}/>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-5 offset-md-1 pb-4">
                                <div className="row align-items-center">
                                    <div className="col-4">
                                        <label htmlFor="ville" className="fs-4">Ville :</label>
                                    </div>
                                    <div className="col-8">
                                        <input id="ville" type="text" className="form-control fs-5" name="ville"
                                               required autoComplete="ville" autoFocus value={utilisateur?.ville}/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        {isEdit ?
                            <>
                                <div className="row form-group mx-auto">
                                    <div className="col-md-5 offset-md-1 pb-4">
                                        <div className="row align-items-center">
                                            <div className="col-4">
                                                <label htmlFor="password"
                                                       className="fs-4">{isEdit ? "Mot de passe actuel :" : "Mot de passe"}</label>
                                            </div>
                                            <div className="col-8">
                                                <input id="password" type="password" className="form-control fs-5"
                                                       name="password" required autoComplete="password" autoFocus
                                                       value={utilisateur?.motDePasse}/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="row form-group mx-auto d-flex align-items-center">
                                    <div className="col-md-5 offset-md-1 pb-4">
                                        <div className="row align-items-center">
                                            <div className="col-4">
                                                <label htmlFor="newPassword" className="fs-4">Nouveau mot de passe
                                                    :</label>
                                            </div>
                                            <div className="col-8">
                                                <input id="newPassword" type="password" className="form-control fs-5"
                                                       name="newPassword" required autoComplete="newPassword"
                                                       autoFocus/>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-md-5 offset-md-1 pb-4">
                                        <div className="row align-items-center">
                                            <div className="col-4">
                                                <label htmlFor="confirmationPassword" className="fs-4">Confirmation
                                                    :</label>
                                            </div>
                                            <div className="col-8">
                                                <input id="confirmationPassword" type="password"
                                                       className="form-control fs-5"
                                                       name="confirmationPassword" required
                                                       autoComplete="confirmationPassword"
                                                       autoFocus/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="row form-group mx-auto">
                                    <div className="col-md-5 offset-md-1 pb-4">
                                        <div className="row align-items-center">
                                            <div className="col-4">
                                                <label htmlFor="credit" className="fs-4">Crédit :</label>
                                            </div>
                                            <div className="col-8">
                                                <input id="credit" type="number" className="form-control fs-5"
                                                       name="credit" value={utilisateur.credit}/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </>
                        :
                            <div className="row form-group mx-auto">
                                <div className="col-md-5 offset-md-1 pb-4">
                                    <div className="row align-items-center">
                                        <div className="col-4">
                                            <label htmlFor="password" className="fs-4">Mot de passe :</label>
                                        </div>
                                        <div className="col-8">
                                            <input id="password" type="password" className="form-control fs-5"
                                                   name="password" required autoComplete="password" autoFocus/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-5 offset-md-1 pb-4">
                                    <div className="row align-items-center">
                                        <div className="col-4">
                                            <label htmlFor="confirmationPassword" className="fs-4">Confirmation
                                                :</label>
                                        </div>
                                        <div className="col-8">
                                            <input id="confirmationPassword" type="password"
                                                   className="form-control fs-5"
                                                   name="confirmationPassword" required
                                                   autoComplete="confirmationPassword"
                                                   autoFocus/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        }

                        {isEdit ?
                            <div className="row form-group my-5 d-flex align-items-center ">
                                <div
                                    className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                    <button type="submit" className="btn btn-secondary btn_confirm btn-md button">
                                        Enregistrer
                                    </button>
                                </div>

                                <div
                                    className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                    <button type="submit" className="btn btn-secondary btn_supp btn-md button">
                                        Supprimer mon compte
                                    </button>
                                </div>

                                <div
                                    className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                    <a href="/"
                                       className="btn btn-secondary btn_supp d-flex align-items-center justify-content-center button">
                                        Annuler
                                    </a>
                                </div>
                            </div>
                            :
                            <div className="row form-group mx-auto mt-4">
                                <div className="col-6 form-group pb-3 text-center mb-4 d-flex justify-content-end">
                                    <button type="submit" className="btn btn-secondary btn_confirm btn-lg button">
                                    Créer
                                </button>
                            </div>

                            <div className="col-6 form-group pb-3 text-center mb-4 d-flex justify-content-start align-items-center ">
                                <a href="/"
                                   className="btn btn-secondary btn_supp btn-lg d-flex align-items-center justify-content-center button">
                                    Annuler
                                </a>
                            </div>
                        </div>
                        }

                    </form>
                </div>

        </div>


    )
}
