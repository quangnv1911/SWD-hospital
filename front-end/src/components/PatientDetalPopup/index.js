import { useEffect, useState } from "react";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import './index.css';

function PatientDetailPopup({ appointmentId, statusValue }) {
    const [patient, setPatient] = useState({});

    useEffect(() => {
        fetch(`http://localhost:8080/appointment?id=${appointmentId}`, {

        })
            .then((response) => {
                if (!response.ok) {

                }
                return response.json();
            })

            .then((item) => {
                const data = {
                    patientId: item.patientId,
                    fullName: item.fullName,
                    phone: item.phone,
                    email: item.email,
                    dateBooking: item.dateBooking,
                    timeBooking: item.timeBooking,
                    address: item.address,
                    medicalHistory: item.medicalHistory,
                    patientProfile: item.patientProfile,
                    InsuranceID: item.InsuranceID,
                    note: item.note,
                    reason: item.reason
                };

                return data;
            })

            .then((result) => {

                setPatient(result);
            });
    }, [appointmentId]);


    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const updateAppointmentStatus = () => {
        fetch(
            `http://localhost:8080/appointment/${appointmentId}`,
            {
                method: "PUT",

                body: JSON.stringify({ status: "confirm" }),

            }
        )
            .then((response) => {
                if (!response.ok) {
                    alert("Save fail!!");
                }
                return response.text();
            })
            .then((data) => {
                console.log("Data saved successfully:", data);
            })
            .catch((error) => {
                console.error("Error saving data:", error);
            });
    };

    if (!patient) {
        return <></>;
    }

    return (
      
        <>
            <Button variant="primary" onClick={handleShow}>
                Xem thêm
            </Button>

            <Modal
                show={show}
                onHide={handleClose}
                keyboard={false}
                dialogClassName="modal-w"
                aria-labelledby="example-custom-modal-styling-title"
            >
                <Modal.Header closeButton>
                    <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLabel">Thông tin bệnh nhân</h5>
                        
                    </div>
                </Modal.Header>
                <Modal.Body>
                    <div className="modal-body">
                        <div className="row">
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientName">Họ và tên:</label>
                                <input type="text" className="form-control" id="patientName" name="patientName" value={patient.fullName} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientPhone">Số điện thoại:</label>
                                <input type="text" className="form-control" id="patientPhone" name="patientPhone" value={patient.phone} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientEmail">Email:</label>
                                <input type="email" className="form-control" id="patientEmail" name="patientEmail" value={patient.email} />
                            </div>
                            <div className="form-group col-2">
                                <label className="col-form-label text-label" htmlFor="patientDate">Ngày đặt lịch:</label>
                                <input type="text" className="form-control" id="patientDate" name="patientDate" readOnly value={patient.dateBooking} />
                            </div>
                            <div className="form-group col-2">
                                <label className="col-form-label text-label" htmlFor="patientTime">Khung giờ:</label>
                                <input type="text" className="form-control" id="patientTime" name="patientTime" readOnly value={patient.timeBooking} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientReason">Lí do:</label>
                                <textarea className="form-control" name="patientReason" id="patientReason">{patient.reason}</textarea>
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientAddress">Địa chỉ:</label>
                                <textarea className="form-control" name="patientAddress" id="patientAddress">{patient.address}</textarea>
                            </div>

                            <div className="col-12">

                            </div>

                            <div className="form-group col-6">
                                <label className="col-form-label text-label" htmlFor="patientHistoryBreath">Tiền sử bệnh:</label>
                                <textarea className="form-control" name="patientHistoryBreath" id="patientHistoryBreath">{patient.patientProfile}</textarea>
                            </div>

                            <div className="form-group col-6">
                                <label className="col-form-label text-label" htmlFor="patientMoreInfo">Thông tin các lần khám trước:</label>
                                <textarea className="form-control" name="patientMoreInfo" id="patientMoreInfo" >{patient.medicalHistory}</textarea>
                            </div>

                            <div className="form-group col-12">
                                <label className="col-form-label text-label" htmlFor="patientNote">Ghi chú:</label>
                                <textarea className="form-control" name="patientNote" id="patientNote">{patient.note}</textarea>
                            </div>
                        </div>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Đóng
                    </Button>
                    {statusValue === "pending" && (
                        <Button variant="primary" onClick={updateAppointmentStatus}>Xác nhận</Button>
                    )}

                </Modal.Footer>
            </Modal>
        </>
    );
}

export default PatientDetailPopup;