🏥 Sistema de Triage Inteligente
Grupo: Triage Inteligente
Integrante: Camilo Lopez

📋 Descripción del Proyecto
El Sistema de Triage Inteligente es un microservicio desarrollado en Spring Boot que simula la evaluación preliminar de síntomas médicos para determinar la especialidad médica recomendada y el nivel de prioridad de atención.

🎯 Funcionalidades Principales

Evaluación Inteligente de Síntomas: Análisis automático basado en reglas médicas
Clasificación por Prioridad: Sistema de 4 niveles (Inmediato, Urgente, Mínimo, Expectante)
Asignación de Especialidades: Más de 15 especialidades médicas diferentes
Generación Automática de Citas: Programación inteligente basada en prioridad
Persistencia de Datos: Almacenamiento en base de datos MySQL


🚨 Sistema de Prioridades Médicas


IMMEDIATE🔴 RojoEmergencias que ponen en peligro la vida - Inmediato

URGENT🟡 AmarilloCondiciones serias que requieren atención pronta 1-2 horas

MINIMAL🟢 VerdeProblemas menores que pueden esperar 24 horas

EXPECTANT⚫ NegroAtención rutinaria o preventiva 1-2 semanas


🔗 Endpoints de la API
🎯 Endpoints Principales (Requeridos)

1. Evaluación de Síntomas

   http POST /triage

{
"patientName": "Juan Pérez",
"symptoms": ["fever", "cough", "headache"]
}

Respuesta:
json{
"specialty": "GENERAL_MEDICINE",
"priority": "URGENT",
"recommendation": "URGENT - Seek medical attention within 1-2 hours"
}

2. Cita Automática
   httpPOST /triage/auto-cita

{
"patientName": "María García",
"symptoms": ["chest_pain", "difficulty_breathing"]
}

Respuesta:
🏥 APPOINTMENT SCHEDULED for María García
📋 Specialty: EMERGENCY_CARDIOLOGY
🚨 Priority: IMMEDIATE
⏰ Timeframe: IMMEDIATELY - Go to Emergency Room NOW
💡 Recommendation: EMERGENCY - Seek immediate medical attention


🎨 Lógica de Negocio Inteligente

🚨 Detección de Emergencias

El sistema identifica automáticamente condiciones críticas:

Dolor de pecho severo

Dificultad respiratoria

Síntomas de derrame cerebral

Sangrado severo

Reacciones alérgicas graves

🏥 Especialidades Médicas

Más de 15 especialidades disponibles:

EMERGENCY_CARDIOLOGY - Cardiología de Emergencia

NEUROLOGY - Neurología

GASTROENTEROLOGY - Gastroenterología

ORTHOPEDICS - Ortopedia

DERMATOLOGY - Dermatología

ENT - Otorrinolaringología

OPHTHALMOLOGY - Oftalmología

Y más...


🚀 Instrucciones de Ejecución
Prerrequisitos

Java 19+
MySQL 8.0+
Maven 3.6+

Configuración

Crear base de datos:

sql CREATE DATABASE hospital;

Configurar application.properties:

properties spring.datasource.url=jdbc:mysql://localhost:3306/hospital

spring.datasource.username=root

spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=create-drop

(Cambiar de acuerdo a su mysql)

🌐 Acceso

URL Base: http://localhost:8070

Endpoints: http://localhost:8070/triage


🧑‍💻 Equipo de Desarrollo

Grupo: Triage Inteligente

Desarrollador: Camilo Lopez

Universidad: UCC

Materia: Programación Orientada a Objetos


🎉 Conclusión
El Sistema de Triage Inteligente representa una solución completa y profesional para la evaluación médica automatizada. Combina lógica de negocio sofisticada con una arquitectura robusta, cumpliendo todos los requisitos del proyecto final y proporcionando una base sólida para un sistema de salud real.

Sistema desarrollado como parte del trabajo final de Programación Orientada a Objetos - UCC 2025