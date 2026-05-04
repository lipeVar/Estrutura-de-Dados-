import csv
import os

# Classe que representa o objeto Aluno
class Aluno:
    def __init__(self, nome, curso, sexo, ano_ingresso):
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = ano_ingresso
    
    # Define como o objeto será visualizado ao ser impresso (print)
    def __str__(self):
        return f"Nome: {self.nome:.<20} | Curso: {self.curso:.<15} | Sexo: {self.sexo} | Ano: {self.ano_ingresso}"

# Classe principal que gerencia as operações do sistema
class SistemaAcademia:
    def __init__(self):
        # Lista que armazenará os objetos da classe Aluno em memória
        self.alunos = []

    # Lê o arquivo CSV e preenche a lista de alunos
    def carregar_dados(self, caminho_arquivo):
        if not os.path.exists(caminho_arquivo):
            print(f"Aviso: Arquivo {caminho_arquivo} não encontrado. Iniciando lista vazia.")
            return

        with open(caminho_arquivo, newline='', encoding='utf-8') as csvfile:
            leitor = csv.reader(csvfile)
            for linha in leitor:
                if linha: # Evita erro com linhas vazias
                    aluno = Aluno(linha[0], linha[1], linha[2], linha[3])
                    self.alunos.append(aluno)

    # Adiciona uma nova linha ao final do arquivo CSV (Modo 'a' de append)
    def salvar_aluno_csv(self, caminho_arquivo, aluno):
        with open(caminho_arquivo, mode='a', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)
            escritor.writerow([aluno.nome, aluno.curso, aluno.sexo, aluno.ano_ingresso])

    # Sobrescreve o arquivo inteiro (usado após exclusões ou edições)
    def reescrever_csv(self, caminho_arquivo):
        with open(caminho_arquivo, mode='w', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)
            for aluno in self.alunos:
                escritor.writerow([aluno.nome, aluno.curso, aluno.sexo, aluno.ano_ingresso])
    
    # Ordenação por nome usando expressão lambda
    def ordenar_nome(self):
        self.alunos.sort(key=lambda aluno: aluno.nome.lower())

    # Ordenação por ano de ingresso
    def ordenar_ano(self):
        self.alunos.sort(key=lambda aluno: aluno.ano_ingresso)

    # Busca linear por nome exato (ignora maiúsculas/minúsculas)
    def buscar_por_nome(self, nome):
        nome_busca = nome.strip().lower()
        for aluno in self.alunos:
            if aluno.nome.strip().lower() == nome_busca:
                return aluno
        return None

    # Agregação: Gera um dicionário com a contagem de alunos por ano
    def calcular_estatisticas(self):
        contagem = {}
        for aluno in self.alunos:
            ano = aluno.ano_ingresso
            contagem[ano] = contagem.get(ano, 0) + 1
        return contagem

    # Exibe todos os alunos da lista atual
    def exibir_alunos(self):
        if not self.alunos:
            print("A lista está vazia.")
        else:
            for aluno in self.alunos:
                print(aluno)

# --- Configurações Iniciais ---
# Defini o nome do arquivo de forma relativa para evitar erros de diretório
ARQUIVO_CSV = "alunos.csv"
sistema = SistemaAcademia()
sistema.carregar_dados(ARQUIVO_CSV)

# --- Loop Principal do Menu ---
while True:
    print("\n" + "="*30)
    print("      GESTÃO ACADÊMICA")
    print("="*30)
    print("1. Exibir Alunos")
    print("2. Ordenar por Nome")
    print("3. Ordenar por Ano")
    print("4. Buscar Aluno por Nome")
    print("5. Adicionar Novo Aluno")
    print("6. Excluir Aluno")
    print("7. Ver Estatísticas (Alunos/Ano)")
    print("8. Sair")
    
    opcao = input("\nEscolha uma opção: ")

    if opcao == "1":
        print("\n--- Lista de Alunos ---")
        sistema.exibir_alunos()

    elif opcao == "2":
        sistema.ordenar_nome()
        print("\nLista ordenada por NOME com sucesso!")
        sistema.exibir_alunos()

    elif opcao == "3":
        sistema.ordenar_ano()
        print("\nLista ordenada por ANO com sucesso!")
        sistema.exibir_alunos()

    elif opcao == "4":
        nome_busca = input("Digite o nome exato para busca: ")
        aluno = sistema.buscar_por_nome(nome_busca)
        if aluno:
            print(f"\nAluno encontrado: {aluno}")
        else:
            print("\nAluno não encontrado.")

    elif opcao == "5":
        nome = input("Nome: ")
        curso = input("Curso: ")
        sexo = input("Sexo (M/F): ")
        ano = input("Ano de Ingresso: ")
        
        novo = Aluno(nome, curso, sexo, ano)
        sistema.alunos.append(novo)
        sistema.salvar_aluno_csv(ARQUIVO_CSV, novo)
        print("\nAluno cadastrado e salvo com sucesso!")

    elif opcao == "6":
        nome_excluir = input("Digite o nome do aluno a ser excluído: ")
        aluno_alvo = sistema.buscar_por_nome(nome_excluir)
        
        if aluno_alvo:
            sistema.alunos.remove(aluno_alvo)
            sistema.reescrever_csv(ARQUIVO_CSV)
            print("\nAluno removido com sucesso!")
        else:
            print("\nAluno não localizado para exclusão.")

    elif opcao == "7":
        estatisticas = sistema.calcular_estatisticas()
        print("\n--- Alunos por Ano ---")
        for ano, qtd in sorted(estatisticas.items()):
            print(f"Ano {ano}: {qtd} aluno(s)")

    elif opcao == "8":
        print("Encerrando o sistema... Até logo!")
        break

    else:
        print("Opção inválida! Tente novamente.")