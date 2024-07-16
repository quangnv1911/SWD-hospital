import './index.css'

function SideBar() {

    return (
        <ul className=" bg-gradient-primary sidebar-dark 
        text-center text-white
        col-md-2" id="accordionSidebar">


            <a className="sidebar-brand d-flex align-items-center justify-content-center" href="/users">
                <div className="sidebar-brand-icon rotate-n-15">
                    <i className="fas fa-laugh-wink"></i>
                </div>
                <div className="sidebar-brand-text mx-3">Doctors Care</div>
            </a>


            <hr className="sidebar-divider my-0" />

            <li className="nav-item">
                <a className="nav-link" href="/users">
                    <i className="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>


            <hr className="sidebar-divider" />



            <div className="sidebar-heading">
                Receptionist
            </div>
            <li className="nav-item supporter-list-patients" id="liSchedule">
                <a className="nav-link" href="/supporter/get-new-patients">
                    <i className="fas fa-procedures"></i>
                    <span>New patients</span></a>
            </li>
            <li className="nav-item supporter-list-posts">
                <a className="nav-link supporter-manage-posts" href="/supporter/manage/posts">
                    <i className="fas fa-newspaper"></i>
                    <span>Posts</span></a>
            </li>
            <li className="nav-item supporter-list-customers">
                <a className="nav-link" href="/supporter/manage/customers">
                    <i className="fas fa-user-shield"></i>
                    <span>Customer care</span></a>
            </li>


            <hr className="sidebar-divider d-none d-md-block" />

            <div className="text-center d-none d-md-inline">
                <button className="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>

    );

}

export default SideBar;