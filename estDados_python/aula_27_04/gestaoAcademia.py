import csv
import os

class Aluno:
    def __init__(self, nome, curso, sexo, ano_ingresso):
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = ano_ingresso
    
    def __str__(self):
        return f"Nome: {self.nome} | Curso: {self.curso} | Sexo: {self.sexo} | Ano: {self.ano_ingresso}"

class SistemaAcademmia:
    def __init__(self):
        self.alunos = []
        # Definimos o caminho do arquivo de forma mais flexível
        self.arquivo_nome = "alunos.csv"

    def carregar_dados(self):
        # Verifica se o arquivo existe antes de tentar ler para evitar erro
        if not os.path.exists(self.arquivo_nome):
            return

        with open(self.arquivo_nome, newline='', encoding='utf-8') as csvfile:
            leitor = csv.reader(csvfile)
            for linha in leitor:
                if linha: # Evita linhas vazias
                    aluno = Aluno(linha[0], linha[1], linha[2], linha[3])
                    self.alunos.append(aluno)

    def salvar_aluno_csv(self, aluno):
        # 'a' (append) para adicionar apenas a nova linha ao final
        with open(self.arquivo_nome, mode='a', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)
            escritor.writerow([aluno.nome, aluno.curso, aluno.sexo, aluno.ano_ingresso])

    def reescrever_csv(self):
        # 'w' (write) para sobrepor o arquivo após exclusões ou ordenações
        with open(self.arquivo_nome, mode='w', newline='', encoding='utf-8') as arquivo:
            escritor = csv.writer(arquivo)
            for aluno in self.alunos:
                escritor.writerow([aluno.nome, aluno.curso, aluno.sexo, aluno.ano_ingresso])
    
    def ordenarNome(self):
        self.alunos.sort(key=lambda aluno: aluno.nome.lower())

    def ordenarAno(self):
        self.alunos.sort(key=lambda aluno: aluno.ano_ingresso)

    def buscar_por_nome(self, nome):
        nome_busca = nome.strip().lower()
        for aluno in self.alunos:
            if aluno.nome.strip().lower() == nome_busca:
                return aluno
        return None

    def porAno(self):
        contagem = {}
        for aluno in self.alunos:
            ano = aluno.ano_ingresso
            contagem[ano] = contagem.get(ano, 0) + 1
        return contagem

    def exibir_alunos(self):
        if not self.alunos:
            print("Nenhum aluno cadastrado.")
        for aluno in self.alunos:
            print(aluno)

def menu():
    sistema = SistemaAcademmia()
    sistema.carregar_dados()

    while True: # Adicionado loop para o menu não fechar após uma opção
        print("\n--- Menu Gestão Acadêmica ---")
        print("1. Exibir Alunos")
        print("2. Ordenar por Ano")
        print("3. Ordenar por Nome")
        print("4. Buscar Aluno por Nome")
        print("5. Relatório: Ingressantes por Ano")
        print("6. Adicionar Novo Aluno")
        print("7. Excluir Aluno")
        print("8. Sair")

        opcao = input("Escolha uma opção: ")
        
        if opcao == "1":
            sistema.exibir_alunos()
        elif opcao == "2":
            sistema.ordenarAno()
            print("Lista ordenada por Ano!")
            sistema.exibir_alunos()
        elif opcao == "3":
            sistema.ordenarNome()
            print("Lista ordenada por Nome!")
            sistema.exibir_alunos()
        elif opcao == "4":
            nome_busca = input("Digite o nome exato: ")
            aluno = sistema.buscar_por_nome(nome_busca)
            if aluno:
                print(f"\nEncontrado: {aluno}")
            else:
                print("Aluno não encontrado.")
        elif opcao == "5":
            relatorio = sistema.porAno()
            print("\n--- Alunos por Ano ---")
            for ano, qtd in relatorio.items():
                print(f"Ano {ano}: {qtd} aluno(s)")
        elif opcao == "6":
            nome = input("Nome: ")
            curso = input("Curso: ")
            sexo = input("Sexo: ")
            ano = input("Ano de Ingresso: ")
            novo = Aluno(nome, curso, sexo, ano)
            sistema.alunos.append(novo)
            sistema.salvar_aluno_csv(novo)
            print("ALUNO ADICIONADO!")
        elif opcao == "7":
            nome_excluir = input("Nome do aluno a excluir: ")
            aluno_excluir = sistema.buscar_por_nome(nome_excluir)
            if aluno_excluir:
                sistema.alunos.remove(aluno_excluir)
                sistema.reescrever_csv()
                print("ALUNO EXCLUÍDO!")
            else:
                print("Aluno não encontrado.")
        elif opcao == "8":
            print("Saindo...")
            break
        else:
            print("Opção inválida!")

if __name__ == "__main__":
<<<<<<< HEAD
    menu()
=======
    menu()
>>>>>>> e911fbee97f40621d5b120a167bf5dfc862bc5b5
