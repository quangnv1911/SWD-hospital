import './index.css'

function SideBar() {

    return (
        <ul class=" bg-gradient-primary sidebar-dark 
        text-center text-white
        col-md-2" id="accordionSidebar">


            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/users">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Doctors Care</div>
            </a>


            <hr class="sidebar-divider my-0" />

            <li class="nav-item">
                <a class="nav-link" href="/users">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>


            <hr class="sidebar-divider" />



            <div class="sidebar-heading">
                Receptionist
            </div>
            <li class="nav-item supporter-list-patients" id="liSchedule">
                <a class="nav-link" href="/supporter/get-new-patients">
                    <i class="fas fa-procedures"></i>
                    <span>New patients</span></a>
            </li>
            <li class="nav-item supporter-list-posts">
                <a class="nav-link supporter-manage-posts" href="/supporter/manage/posts">
                    <i class="fas fa-newspaper"></i>
                    <span>Posts</span></a>
            </li>
            <li class="nav-item supporter-list-customers">
                <a class="nav-link" href="/supporter/manage/customers">
                    <i class="fas fa-user-shield"></i>
                    <span>Customer care</span></a>
            </li>


            <hr class="sidebar-divider d-none d-md-block" />

            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>

    );

}

export default SideBar;