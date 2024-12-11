// NOME: RENAN FELIPE STRAUB CZERVINSKI
// CURSO: Bacharelado em Ciência da Computação
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "FreeRTOS.h"
#include "task.h"

#define HORARIO 1
#define ANTI_HORARIO 0
#define FRENTE 1
#define ATRAS 0
#define DIREITA 1
#define ESQUERDA 0

int motor0 = 0, motor1 = 0, motor2 = 0, motor3 = 0; //motor comeca em 0

void tarefaGuinada(void* pvParameters);
void tarefaArfagem(void* pvParameters);
void tarefaRolagem(void* pvParameters);

// função principal
int main_(void) {
    srand(time(NULL));

    // criação das tarefas
    xTaskCreate(tarefaGuinada, "Guinada", 1000, NULL, 1, NULL);
    xTaskCreate(tarefaArfagem, "Arfagem", 1000, NULL, 1, NULL);
    xTaskCreate(tarefaRolagem, "Rolagem", 1000, NULL, 1, NULL);

    vTaskStartScheduler();

    for (;;);
}

void tarefaGuinada(void* pvParameters) {
    int direcao;
    for (;;) {
        direcao = rand() % 2; // 0 para ANTI_HORARIO, 1 para HORARIO
        if (direcao == HORARIO) {
            motor0 += 100; motor2 += 100;
            motor1 -= 100; motor3 -= 100;
        }
        else {
            motor0 -= 100; motor2 -= 100;
            motor1 += 100; motor3 += 100;
        }

        vPrintString("Manobra: Guinada\n");
        printf("Direcao: %s\n", direcao == HORARIO ? "Horario" : "Anti-horario");
        printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
        printf("\n");
        vTaskDelay(pdMS_TO_TICKS(10)); // 10ms 

    }
    vTaskDelete(NULL);
}

void tarefaArfagem(void* pvParameters) {
    int direcao;
    for (;;) {
        direcao = rand() % 2; // 0 para ATRAS, 1 para FRENTE
        if (direcao == FRENTE) {
            motor2 += 25; motor3 += 25;
            motor0 -= 25; motor1 -= 25;
        }
        else {
            motor2 -= 25; motor3 -= 25;
            motor0 += 25; motor1 += 25;
        }

        vPrintString("Manobra: Arfagem\n");
        printf("Direcao: %s\n", direcao == FRENTE ? "Frente" : "Atras");
        printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
        printf("\n");
        vTaskDelay(pdMS_TO_TICKS(40)); // 40ms 


    }
    vTaskDelete(NULL);

}
void tarefaRolagem(void* pvParameters) {
    int direcao;
    for (;;) {
        direcao = rand() % 2; // 0 para ESQUERDA, 1 para DIREITA
        if (direcao == DIREITA) {
            motor0 += 50; motor3 += 50;
            motor1 -= 50; motor2 -= 50;
        }
        else {
            motor0 -= 50; motor3 -= 50;
            motor1 += 50; motor2 += 50;
        }

        vPrintString("Manobra: Rolagem\n");
        printf("Direcao: %s\n", direcao == DIREITA ? "Direita" : "Esquerda");
        printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
        printf("\n");
        vTaskDelay(pdMS_TO_TICKS(20)); // 20ms 
    }
    vTaskDelete(NULL);

}