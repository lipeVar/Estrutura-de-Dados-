# 2) faça uma função recursiva que receba um número, uma lista, seu tamanho/comprimento e substitua o número pelo valor -1.
#  DICA: recursao sem retorno de valor (sem return)

def substitui(lista, n):
    if n >0:
        if lista[n-1] == 1:
            lista[n-1] = -1
            substitui(lista, n-1)
        else:
            substitui(lista, n-1)


lista = [1, 4, 5, 1, 1, 1]

print("Lista antes da substituição: ",lista)
substitui(lista, len(lista))
print("Lista depois da substituição: ",lista)