# 3) faça uma função recursiva que receba um número, uma lista, seu tamanho/comprimento e retorne a posição do número na lista
#  (ou -1 se o número não estiver presente). DICA: recursao com retorno de valor (return)

def posicao(lista, n):
    if n>0:
        if lista[n-1] == 5:
            return n-1
        else:
            return posicao(lista, n-1)
    else:
        return -1


lista = [1, 4, 10, 3, 6, 0, 9]
print("Posição do número: ",posicao(lista, len(lista)))