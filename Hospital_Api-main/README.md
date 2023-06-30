# Hospital API

## Tech Stack Used
- Core Java
- Spring Boot
- Hibernate
- MySQL database

## Data Flow
### Controllers
- DoctorController
- PatientController
- StatusController
- SymptomController
- SpecialityController

### Services
- DoctorService
- PatientService
- StatusService
- SymptomService
- SpecialityService

### DAO (Data Access Objects)
- DoctorDao
- PatientDao
- StatusDao
- SymptomDao
- SpecialityDao

## Project Summary
This project involves the development of a backend system for a platform that allows doctors to register their patients. The system provides various APIs for adding doctors, adding patients along with their symptoms, and suggesting suitable doctors based on the patient's symptom and location.

The database consists of two entities: Doctor and Patient. Doctors are identified by their name, city, email, phone number, and speciality. The city field can have one of three values: Delhi, Noida, or Faridabad. The speciality field can have one of four values: Orthopedic, Gynecology, Dermatology, or ENT specialist.

Patients are identified by their name, city, email, phone number, and symptom. The symptom field can have one of the following values: Arthritis, Back Pain, Tissue injuries, Dysmenorrhea, Skin infection, Skin burn, or Ear pain.

The system enforces validations for several fields, including name, city, email, and phone number.

The "Suggesting Doctors" API takes a patient ID as input and returns a list of doctors based on the patient's symptom and location. The system ensures that only doctors with a speciality matching the patient's symptom are suggested. It also handles scenarios where there are no doctors available in the patient's location or no doctors available for the patient's symptom in that location.

The system is built using the Spring Boot framework to implement core functionalities, and Hibernate is used for performing database operations. API documentation is done using Swagger.
