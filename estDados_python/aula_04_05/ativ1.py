# exercícios de fixação
# 1) faça uma função recursiva que receba um número, uma lista, seu tamanho/comprimento e retorne a quantidade
#  de vezes que o número aparece na lista. DICA: recursao com retorno de valor (return)

def repetido(lista, n):
    if n > 0:
        if lista[n-1] == 1:
            return 1 + repetido(lista, n-1)
        else:
            return 0 + repetido(lista, n-1)
    else:
        return 0
        


lista = [1, 4, 5, 1, 1, 1]

print("Numero de repetições: ",repetido(lista, len(lista)))
 
