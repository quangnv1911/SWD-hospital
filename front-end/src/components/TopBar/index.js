function TopBar() {

    return (
        <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow
        d-flex justify-content-end">


            <button id="sidebarToggleTop" className="btn btn-link d-md-none rounded-circle mr-3">
                <i className="fa fa-bars"></i>
            </button>

            <ul className="navbar-nav ml-auto">
                <div className="topbar-divider d-none d-sm-block"></div>

              
                <li className="nav-item dropdown no-arrow">
                    <a className="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span className="mr-2 d-none d-lg-inline text-gray-600 small">Receptionist</span>
                        <img style={{width: "50px"}} alt="receptionist" className="img-profile rounded-circle" src="https://www.shutterstock.com/image-vector/transparent-hospital-receptionist-icon-png-260nw-1981161338.jpg" />
                    </a>
                    <div className="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                        <a className="dropdown-item user-setting" data-user-id="<%= user.id %>" href="#">
                            <i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                            Settings
                        </a>
                        <a className="dropdown-item" href="/logout" >
                            <i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            Log out
                        </a>
                    </div>
                </li>
            </ul>
        </nav>

    );

}

export default TopBar;