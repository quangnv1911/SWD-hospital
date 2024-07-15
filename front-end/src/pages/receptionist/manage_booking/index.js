import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import NewAppointment from '../../../components/NewAppointment';
import ConfirmAppointment from '../../../components/ConfirmAppointment';
import CancelAppointment from '../../../components/CancelAppointment';

const App = () => {
    const [activeTab, setActiveTab] = useState('newPatients');

    return (
        <div style={{ minHeight: "600px" }}>
            <div className="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 className="h3 mb-0 text-gray-800">Manage patients</h1>
            </div>
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <ul className="nav nav-tabs" id="myTab" role="tablist">
                        <li className="nav-item">
                            <a

                                className={`nav-link ${activeTab === 'newPatients' ? 'active' : ''}`}
                                id="patient-new-tab"
                                onClick={() => setActiveTab('newPatients')}
                                role="tab"
                                aria-controls="newPatients"
                                aria-selected={activeTab === 'newPatients'}
                            >
                                New patients
                            </a>
                        </li>

                        <li className="nav-item">
                            <a
                                className={`nav-link ${activeTab === 'patientConfirmed' ? 'active' : ''}`}
                                id="patient-confirmed-tab"
                                onClick={() => setActiveTab('patientConfirmed')}
                                role="tab"
                                aria-controls="patientConfirmed"
                                aria-selected={activeTab === 'patientConfirmed'}
                            >
                                Confirmed
                            </a>
                        </li>
                        <li className="nav-item">
                            <a
                                className={`nav-link ${activeTab === 'patientCanceled' ? 'active' : ''}`}
                                id="patient-cancel-tab"
                                onClick={() => setActiveTab('patientCanceled')}
                                role="tab"
                                aria-controls="patientCanceled"
                                aria-selected={activeTab === 'patientCanceled'}
                            >
                                Cancelled
                            </a>
                        </li>
                    </ul>
                </div>
                <div className="card-body">
                    <div className="table-responsive">
                        <div className="tab-content" id="myTabContent">
                            <div
                                className={`tab-pane fade ${activeTab === 'newPatients' ? 'show active' : ''}`}
                                id="newPatients"
                                role="tabpanel"
                                aria-labelledby="patient-new-tab"
                            >
                                <table className="table table-bordered text-center" id="tableNewPatients" width="100%" cellSpacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID </th>
                                            <th>Name</th>
                                            <th>Phone number</th>
                                            <th>Email</th>
                                            <th>Update</th>
                                            <th className="w-25">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <NewAppointment />
                                    </tbody>
                                </table>
                            </div>

                            <div
                                className={`tab-pane fade ${activeTab === 'patientConfirmed' ? 'show active' : ''}`}
                                id="patientConfirmed"
                                role="tabpanel"
                                aria-labelledby="patient-confirmed-tab"
                            >
                                <table className="table table-bordered" id="tableConfirmedPatients" width="100%" cellSpacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID </th>
                                            <th>Name</th>
                                            <th>Phone number</th>
                                            <th>Email</th>
                                            <th>Update</th>
                                            <th className="w-25">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <ConfirmAppointment />
                                    </tbody>
                                </table>
                            </div>
                            <div
                                className={`tab-pane fade ${activeTab === 'patientCanceled' ? 'show active' : ''}`}
                                id="patientCanceled"
                                role="tabpanel"
                                aria-labelledby="patient-cancel-tab"
                            >
                                <table className="table table-bordered" id="tableCancelPatients" width="100%" cellSpacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID </th>
                                            <th>Name</th>
                                            <th>Phone number</th>
                                            <th>Email</th>
                                            <th>Update</th>
                                            <th className="w-25">Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <CancelAppointment />
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    );
};

export default App;
