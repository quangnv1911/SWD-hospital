import { useEffect, useState } from "react";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import './index.css';
import DoctorAvailable from "../DoctorAvailable";
import PatientMedicalHistory from "../PatientMedicalHistory";

function PatientDetailPopup({ appointment, statusValue }) {

    const [note, setNote] = useState(appointment.note || '');

    const handleNoteChange = (event) => {
        setNote(event.target.value);
    };
    const [selectedDoctorId, setSelectedDoctorId] = useState();
    console.log(selectedDoctorId)
    const handleSelectChange = (event) => {
        setSelectedDoctorId(event.target.value);
    };
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const updateAppointmentStatus = (status) => {

        if (window.confirm("Bạn có chắc muốn thực hiện hành động này không")) {

            const data = appointment;
            data.status = status;
            if (statusValue === 'PENDING') {
                data.doctorInfo.doctorId = selectedDoctorId;
                // data.note = note;
            }
            fetch(
                `http://localhost:8080/appointment/${appointment.id}`,
                {
                    headers: {
                        "Content-Type": "application/json",
                    },
                    method: "PUT",
                    body: JSON.stringify(data),
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
                    handleClose();
                    alert("Confirm successfully");
                    window.location.reload();
                })
                .catch((error) => {
                    console.error("Error saving data:", error);
                });
        }
    };

    if (!appointment) {
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
                                <input type="text" disabled className="form-control" id="patientName" name="patientName" value={`${appointment.patientInfo.firstName} - ${appointment.patientInfo.lastName}`} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientPhone">Số điện thoại:</label>
                                <input type="text" disabled className="form-control" id="patientPhone" name="patientPhone" value={appointment.patientInfo.phoneNumber} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientEmail">Email:</label>
                                <input type="email" disabled className="form-control" id="patientEmail" name="patientEmail" value={appointment.patientInfo.email} />
                            </div>
                            <div className="form-group col-2">
                                <label className="col-form-label text-label" htmlFor="patientDate">Ngày đặt lịch:</label>
                                <input type="text" disabled className="form-control" id="patientDate" name="patientDate" readOnly value={appointment.date} />
                            </div>
                            <div className="form-group col-2">
                                <label className="col-form-label text-label" htmlFor="patientTime">Khung giờ:</label>
                                <input type="text" disabled className="form-control" id="patientTime" name="patientTime" readOnly value={`${appointment.startTime} - ${appointment.endTime}`} />
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientReason">Lí do:</label>
                                <textarea disabled className="form-control" name="patientReason" id="patientReason">{appointment.reason}</textarea>
                            </div>
                            <div className="form-group col-4">
                                <label className="col-form-label text-label" htmlFor="patientAddress">Địa chỉ:</label>
                                <textarea disabled className="form-control" name="patientAddress" id="patientAddress">{appointment.patientInfo.address}</textarea>
                            </div>

                            <div className="col-12">

                            </div>

                            <div className="form-group col-6">
                                <label className="col-form-label text-label" htmlFor="patientHistoryBreath">Bác sĩ phụ trách:</label>
                                {appointment.status === 'PENDING' ? (
                                    <select
                                        style={{ height: "60px" }}
                                        className="form-control"
                                        name="patientHistoryBreath"
                                        id="patientHistoryBreath"
                                        value={selectedDoctorId}
                                        defaultValue={appointment.doctorInfo.doctorId}
                                        onChange={handleSelectChange}
                                    >
                                        <DoctorAvailable appointment={appointment} />
                                    </select>
                                ) : (
                                    <input
                                        type="text"
                                        style={{height: "61px"}}
                                        disabled
                                        className="form-control"
                                        name="patientHistoryBreath"
                                        id="patientHistoryBreath"
                                        value={`${appointment.doctorInfo.firstName} ${appointment.doctorInfo.lastName}`}
                                        onChange={handleSelectChange}
                                    />
                                )}

                            </div>


                            <div className="form-group col-6">
                                <label className="col-form-label text-label" htmlFor="patientMoreInfo">Thông tin các lần khám trước:</label>
                                <PatientMedicalHistory patientId={appointment.patientInfo.patientId} />
                            </div>
                            {/* 
                            <div className="form-group col-12">
                                <label className="col-form-label text-label" htmlFor="patientNote">Ghi chú:</label>
                                <textarea className="form-control" name="patientNote" id="patientNote" value={note}
                onChange={handleNoteChange}></textarea>
                            </div> */}
                        </div>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Đóng
                    </Button>
                    {statusValue === "PENDING" && (
                        <>
                            <Button variant="danger" onClick={() => updateAppointmentStatus("CANCELLED")}>Hủy </Button>
                            <Button variant="primary" onClick={() => updateAppointmentStatus("CONFIRMED")}>Xác nhận</Button>
                        </>

                    )}

                </Modal.Footer>
            </Modal>
        </>
    );
}

export default PatientDetailPopup;