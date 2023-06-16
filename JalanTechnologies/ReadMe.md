# README

This is a Java code package for a simple program that generates a bill for car services based on the type of vehicle and selected services. It includes classes for vehicles, services, and a billing system.

## Sample Output
![image](https://github.com/shirishjaiswal/Assignment/assets/98471211/12d51686-37ce-4ae7-a12e-5a0e83a43477)
## Getting Started

To run the program, follow these steps:

1. Ensure you have Java installed on your machine.
2. Clone the repository or download the code files.
3. Open the code in your preferred Java development environment.
4. Compile and run the `Driver` class.

## Code Structure

The code package is structured as follows:

- **com.jalanTechnologies.oop** package:
  - **Driver** class: The main class that contains the entry point for the program. It prompts the user to select a car type and services, and generates the bill accordingly.
  - **Bill** class: Represents the bill generator. It takes a vehicle and a set of service codes, calculates the total bill, and generates the bill details.
- **com.jalanTechnologies.oop.services** package:
  - **Service** interface: Defines the contract for a service. It includes methods to get the service code and charge for different types of vehicles.
  - Concrete service classes such as **BasicService**, **BrakeFixing**, **ClutchFixing**, **EngineFixing**, and **GearFixing** that implement the **Service** interface.
- **com.jalanTechnologies.oop.vehicals** package:
  - **Vehical** interface: Defines the contract for a vehicle. It includes a method to get the name of the vehicle.
  - Concrete vehicle classes such as **HatchBack**, **Sedan**, and **SUV** that implement the **Vehical** interface.

## Usage

When you run the program, you will be prompted to select a car type (Hatchback, Sedan, or SUV) and choose services from the provided options. The program will calculate the total bill based on your selections and display the bill details.
