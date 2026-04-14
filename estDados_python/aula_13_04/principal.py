from matriz import *

def main():
    dimensao = 10

    # Criar uma matriz de dimensão 10x10
    matriz = [[0 for _ in range(dimensao)] for _ in range(dimensao)]

    inicializar_matriz(matriz) # type: ignore

    matriz[0][3] = 1
    matriz[2][5] = 1
    matriz[5][7] = 1
    matriz[6][8] = 1

    exibir_matriz(matriz) # type: ignore

    lista = converter_matriz_lista(matriz) # type: ignore

    exibir_lista(lista) # type: ignore

if __name__ == "__main__":
    main()