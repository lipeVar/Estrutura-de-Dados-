class Glicemia:
    def __init__(self, valor, data, hora):
        """construtor básico com os 3 tributos de classe

        Args:
            valor(int): de glicemia de sangue           
            data()
        """
        self.valor = valor
        self.data = data
        self.hora = hora

    def __eq__(self, outro):
        if not isinstance(outro, Glicemia):
            return False
        return self.data == outro.data and self.hora == outro.hora
    
    def __str__(self):
        return f'Valor glicemia: {self.valor}. Data: {self.data}. Hora: {self.hora}'
    
    @staticmethod
    def calcular_media(lista):
        soma = 0
        for item in lista:
            soma += int(item.valor)

        return int(soma/len(lista))