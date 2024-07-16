import { useEffect, useState } from 'react';

function PatientMedicalHistory({patientId}) {
    const [healthRecords, setHealthRecords] = useState([]);
    
    useEffect(() => {
        console.log(patientId)
        fetch(`http://localhost:8080/patient-history/patient/${patientId.toString()}`, {
        })
            .then((response) => {
                if (!response.ok) {

                }
                return response.json();
            })
            .then((result) => {

                setHealthRecords(result);
            });
    }, [patientId]);

    if(!patientId){
        return <></>;
    }
    return (
        <textarea className="form-control" name="patientMoreInfo" id="patientMoreInfo" disabled
        value={healthRecords.map(healthRecord => `${healthRecord.visitDate} - ${healthRecord.diagnosis}`).join('\n')}
        >

        </textarea>

    );

}

export default PatientMedicalHistory;