class HashTable:
    def __init__(self, size=11):
        self.size = size
        self.buckets = [[] for _ in range(size)]

    def function_hash(self, key):
        return key % self.size

    def inserir(self, matricula, nome, idade):
        index = self.function_hash(matricula)
        bucket = self.buckets[index]

        for aluno in bucket:
            if aluno["matricula"] == matricula:
                print("Erro: matrícula já cadastrada!")
                return

        bucket.append({
            "matricula": matricula,
            "nome": nome,
            "idade": idade
        })

    def buscar(self, matricula):
        index = self.function_hash(matricula)
        bucket = self.buckets[index]

        for aluno in bucket:
            if aluno["matricula"] == matricula:
                return aluno

        return None

    def remover(self, matricula):
        index = self.function_hash(matricula)
        bucket = self.buckets[index]

        for i, aluno in enumerate(bucket):
            print(f"{i}: {bucket}")

    def mostrar(self):
        print("\n========= TABELA HASH =========")
        for i, bucket in enumerate(self.buckets):
            print(f"{i}: {bucket}")
        print("================================\n")


def menu():
    tabela = HashTable()

    while True:
        print("""
===== MENU =====
1. Inserir novo Aluno
2. Buscar Aluno
3. Remover Aluno
4. Exibir Tabela Hash
5. Encerrar Sistema
""")
        opc = input("Escolha uma opção: ")

        if opc == "1":
            try:
                matricula = int(input("Matrícula: "))
                nome = input("Nome: ")
                idade = int(input("Idade: "))
                tabela.inserir(matricula, nome, idade)
            except:
                print("❌ Dados inválidos!")

        elif opc == "2":
            matricula = int(input("Digite a matrícula do aluno: "))
            aluno = tabela.buscar(matricula)
            if aluno:
                print("\nAluno encontrado:")
                print(aluno)
            else:
                print("\n❌ Matrícula não encontrada!")

        elif opc == "3":
            matricula = int(input("Digite a matrícula do aluno: "))
            tabela.remover(matricula)

        elif opc == "4":
            tabela.mostrar()

        elif opc == "5":
            print("\nSistema encerrado!")
            break

        else:
            print("❌ Opção inválida! Tente novamente.")


# Iniciar programa
menu()