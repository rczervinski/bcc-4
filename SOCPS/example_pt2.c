// NOME: RENAN FELIPE STRAUB CZERVINSKI
// CURSO:BCC - 4A
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "FreeRTOS.h"
#include "task.h"
#include <semphr.h>
#include <string.h>

SemaphoreHandle_t xBinarySemaphore; // cria semaforo binario;

volatile long motor0 = 0;
volatile long motor1 = 0;
volatile long motor2 = 0;
volatile long motor3 = 0; // motores começam em 0

volatile char sentido[10];
volatile char direcao[10];
volatile char orientacao[10];

void tarefaGuinada(void* pvParameters);
void tarefaArfagem(void* pvParameters);
void tarefaRolagem(void* pvParameters);
void radioFrequencia(void* pvParameters);

// função principal
int main_(void) {

    xBinarySemaphore = xSemaphoreCreateBinary();
    xSemaphoreGive(xBinarySemaphore);

    if (xBinarySemaphore != NULL) {
        xTaskCreate(tarefaGuinada, "Guinada", 1000, (void*)"horario", 2, NULL);
        xTaskCreate(tarefaArfagem, "Arfagem", 1000, (void*)"frente", 2, NULL);
        xTaskCreate(tarefaRolagem, "Rolagem", 1000, (void*)"direita", 2, NULL);
        xTaskCreate(radioFrequencia, "RadioFreq", 1000, NULL, 1, NULL);

        vTaskStartScheduler();
    }
    for (;;);
}

void tarefaGuinada(void* pvParameters) {

    strcpy((char*)sentido, (char*)pvParameters); //atribui o valor à variavel sentido por parametro da func
    for (;;) {
        if (xSemaphoreTake(xBinarySemaphore, portMAX_DELAY) == pdTRUE) {

            if (strcmp((char*)sentido, "horario") == 0) {
                motor0 += 100; motor2 += 100;
                motor1 -= 100; motor3 -= 100;
            }
            else {
                motor0 -= 100; motor2 -= 100;
                motor1 += 100; motor3 += 100;
            }

            printf("Manobra: Guinada\n");
            printf("Sentido: %s\n", sentido);
            printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
            printf("\n");

            xSemaphoreGive(xBinarySemaphore);
        }
        vTaskDelay(portTICK_RATE_MS * 10); // 10ms de delay
    }
    vTaskDelete(NULL);
}

void tarefaArfagem(void* pvParameters) {
    strcpy((char*)direcao, (char*)pvParameters);//atribui o valor à variavel direcao por parametro da func
    for (;;) {
        if (xSemaphoreTake(xBinarySemaphore, portMAX_DELAY) == pdTRUE) {

            if (strcmp((char*)direcao, "frente") == 0) {
                motor2 += 25; motor3 += 25;
                motor0 -= 25; motor1 -= 25;
            }
            else if (strcmp((char*)direcao, "tras") == 0) {
                motor2 -= 25; motor3 -= 25;
                motor0 += 25; motor1 += 25;
            }

            printf("Manobra: Arfagem\n");
            printf("Direção: %s\n", direcao);
            printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
            printf("\n");

            xSemaphoreGive(xBinarySemaphore);
        }
        vTaskDelay(portTICK_RATE_MS * 40); // 40ms de delay
    }
    vTaskDelete(NULL);
}

void tarefaRolagem(void* pvParameters) {
    strcpy((char*)orientacao, (char*)pvParameters); //atribui o valor à variavel orientacao por parametro da func

    for (;;) {
        if (xSemaphoreTake(xBinarySemaphore, portMAX_DELAY) == pdTRUE) {

            if (strcmp((char*)orientacao, "direita") == 0) {
                motor0 += 50; motor3 += 50;
                motor1 -= 50; motor2 -= 50;
            }
            else if (strcmp((char*)orientacao, "esquerda") == 0) {
                motor0 -= 50; motor3 -= 50;
                motor1 += 50; motor2 += 50;
            }

            printf("Manobra: Rolagem\n");
            printf("Orientação: %s\n", orientacao);
            printf("Velocidades: M0=%d, M1=%d, M2=%d, M3=%d\n", motor0, motor1, motor2, motor3);
            printf("\n");

            xSemaphoreGive(xBinarySemaphore);
        }
        vTaskDelay(portTICK_RATE_MS * 20); // 20ms de delay
    }
    vTaskDelete(NULL);
}

void radioFrequencia(void* pvParameters) {
    for (;;) {
        if (xSemaphoreTake(xBinarySemaphore, portMAX_DELAY) == pdTRUE) { //semaforo para a os rands

            int x = rand() % 100; // valores rand para x,y e z
            int y = rand() % 100;
            int z = rand() % 100;

            if (x % 2 == 0) { // verificador para impar ou par
                sprintf((char*)sentido, "horario");
            }
            else {
                sprintf((char*)sentido, "antihorario");
            }

            if (y % 2 == 0) {
                sprintf((char*)direcao, "frente");
            }
            else {
                sprintf((char*)direcao, "tras");
            }

            if (z % 2 == 0) {
                sprintf((char*)orientacao, "direita");
            }
            else {
                sprintf((char*)orientacao, "esquerda");
            }

            printf("RadioFreq: Variaveis atualizadas.\n");
            printf("Sentido: %s\nDirecao: %s\nOrientacao: %s\n", sentido, direcao, orientacao);
            printf("\n");

            xSemaphoreGive(xBinarySemaphore);
        }
        vTaskDelay(portTICK_RATE_MS * 100); // 100ms de delay
    }
}
