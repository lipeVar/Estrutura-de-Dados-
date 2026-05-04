#Formato: disponibilizar os códigos no seu github pessoal e enviar email para alexz@ufn.edu.br com ASSUNTO: Trabalho ED CC
#Proposta de Trabalho: Gestão Acadêmica
#
#Objetivo: Implementar um sistema que processe o histórico de ingressantes e gere relatórios estatísticos simples. Os dados devem ser carregados do arquivo alunos.csv.
#
#Tarefas:
#* Criar uma classe Aluno com os atributos correspondentes (ver arquivo - Nome,Curso,Sexo,AnoIngresso).
#
#* Ler o arquivo alunos.csv, instanciar os objetos e armazená-los em uma lista.
#
#* Criar funções (orientadas a objetos) 
#     * Ordenar a lista final por "Ano de Ingresso" ou "Nome" antes de exibir
#    * Criar um método que busque um aluno pelo nome exato na lista e retorne seus dados.
#* Agregação: Calcular quantos alunos ingressaram em cada ano.

import csv
import os

class Aluno:
    def __init__(self, nome, curso, sexo, ano_ingresso):
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = ano_ingresso
    
    def __str__(self):
        return f"Nome: {self.nome}, Curso: {self.curso}, Sexo: {self.sexo}, Ano de Ingresso: {self.ano_ingresso}"

class SistemaAcademmia:
    def __init__(self):
        self.alunos = []

    #Ler Arquivo
    def carregar_dados(self, caminho_arquivo):
        base_dir = os.path.dirname(__file__) 
        caminho_completo = os.path.join(base_dir, caminho_arquivo)
        with open(caminho_arquivo, newline='', encoding='utf-8') as csvfile:
            leitor = csv.reader(csvfile)

            for linha in leitor:
                aluno = Aluno(
                    linha[0],  # Nome
                    linha[1],  # Curso
                    linha[2],  # Sexo
                    linha[3]   # Ano
            )
                self.alunos.append(aluno)
    #Adicionar aluno no arquivo
    def salvar_aluno_csv(self, caminho_arquivo, aluno):
        base_dir = os.path.dirname(__file__)
        caminho_completo = os.path.join(base_dir, caminho_arquivo)

        with open(caminho_completo, mode='a', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)
            escritor.writerow([
                aluno.nome,
                aluno.curso,
                aluno.sexo,
                aluno.ano_ingresso
            ])

    #Reescreve arquivo para excluir aluno ou atualizar dados
    def reescrever_csv(self, caminho_arquivo):
        base_dir = os.path.dirname(__file__)
        caminho_completo = os.path.join(base_dir, caminho_arquivo)

        with open(caminho_completo, mode='w', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)

            for aluno in self.alunos:
                escritor.writerow([
                    aluno.nome,
                    aluno.curso,
                    aluno.sexo,
                    aluno.ano_ingresso
            ])
    
    #ordenar
    def ordenarNome(self):
        self.alunos.sort(key=lambda aluno: aluno.nome)
    def ordenarAno(self):
        self.alunos.sort(key=lambda aluno: aluno.ano_ingresso)

    #buscar aluno
    def buscar_por_nome(self, nome):
        nome = nome.strip().lower()

        for aluno in self.alunos:
            if aluno.nome.strip().lower() == nome:
                return aluno
        return None

    #agregação
    def porAno(self):
        contagem = {}
        for aluno in self.alunos:
            ano = aluno.ano_ingresso
            if ano in contagem:
                contagem[ano] += 1
            else:
                contagem[ano] = 1
        return contagem

    #Exibi a lista
    def exibir_alunos(self):
        for aluno in self.alunos:
            print(aluno)

def menu():
    print("\n--- Menu ---")
    print("1. Exibir Alunos")
    print("2. Ordenar por Ano")
    print("3. Buscar Aluno")
    print("4. Adicionar novo aluno")
    print("5. Excluir aluno")
    print("6. Sair")

    opcao = input("Escolha uma opção: ")
    
    if opcao == "1":
        sistema.exibir_alunos()
    elif opcao == "2":
        sistema.ordenarAno()
        print("Alunos ordenados por ano de ingresso!!")
        sistema.exibir_alunos()
    elif opcao == "3":
        nome_busca = input("Digite o nome do aluno:")
        aluno = sistema.buscar_por_nome(nome_busca)
        ("\nResultado: ")
        if aluno:
            print(aluno)
        else:
            print("Aluno não encontrado.")
    elif opcao == "4":
        nome = input("Digite o nome do novo aluno:")
        curso = input("Digite o curso do aluno:")
        sexo = input("Digite o sexo do aluno:")
        ano = input("Digite o ano de ingresso do aluno:")

        novo_aluno = Aluno(nome, curso, sexo, ano)
        sistema.alunos.append(novo_aluno)
        sistema.salvar_aluno_csv("alunos.csv", novo_aluno)
        print("ALUNO ADICIONADO COM SUCESSO!!")
    elif opcao == "5":
        nome_excluir = input("Digite o nome do aluno a ser excluido:")
        aluno_excluir = sistema.buscar_por_nome(nome_busca)

        if aluno_excluir:
            sistema.alunos.remove(aluno_excluir)
            sistema.reescrever_csv("estDados_python/aula_27_04/alunos.csv")
            print("ALUNO EXCLUIDO COM SUCESSO!!")
        else:
            print("ALUNO NÃO ENCONTRADO.")
    elif opcao == "6":
        print("SAINDO DO PROGRAMA...")
        exit()
    else:
        print("OPÇÃO INVÁLIDA!!")



##################################
#                                #   
#       Programa Principal       #
#                                #     
##################################

sistema = SistemaAcademmia()

sistema.carregar_dados("estDados_python/aula_27_04/alunos.csv")

menu()