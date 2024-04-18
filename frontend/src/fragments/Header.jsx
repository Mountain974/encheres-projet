import PropTypes from "prop-types";

export const Header = ({ isConnected }) => {
  return (
    <div id="header3">
      <nav className="navbar navbar-expend-lg bg-body-tertiary">
        <div className="col-12 col-md-4">
          <a href="/" className="logo fs-4">
            ENI-Encheres
          </a>
        </div>

        <div className="col-12 col-md-8 d-flex flex-column flex-md-row justify-content-md-end align-items-md-center m-0">
          {isConnected ? (
            <>
              <div className="text-lg-center text-left px-4">
                <a className="fs-5" href="/home">
                  Enchères
                </a>
              </div>

              <div className="text-lg-center text-left px-4">
                <a className="fs-5" href="/vendre-un-article">
                  Vendre un article
                </a>
              </div>

              <div className="text-lg-center text-left px-4">
                <a className="fs-5" href="/mon-profil">
                  Mon profil
                </a>
              </div>

              <div className="text-lg-center text-left px-4">
                <a className="fs-5" style={{ whiteSpace: "nowrap" }} href="/">
                  Déconnexion
                </a>
              </div>
            </>
          ) : (
            <>
              <div className="d-flex align-items-center col-md-3 ms-4">
                <a className="text-center fs-5" href="/register">
                  S&apos;inscrire
                </a>
              </div>

              <div className="d-flex align-items-center col-md-3 ms-4">
                <a
                  className="text-center fs-5"
                  style={{ whiteSpace: "nowrap" }}
                  href="/login"
                >
                  Se connecter
                </a>
              </div>
            </>
          )}
        </div>
      </nav>
    </div>
  );
};

Header.propTypes = {
  isConnected: PropTypes.bool,
};

export default Header;
