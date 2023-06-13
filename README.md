# Acompanha-Aluno
 

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/acompanha-aluno/blob/main/LICENSE) 

# Sobre o projeto


Acompanha Aluno é uma API REST.

Feita em Java utilizando o Fremawork Spring boot com o proposito de realizar Vários CRUDs para acompanhamento de presença de Alunos.
Nessa API podemos realizar cadastro de uma Escola(School), cadastrar Turmas(ClassSchool) informando a Escola(School), também cadastramos o Professor(Teacher) e informamaos uma ou mais Turmas(ClassSchool) que ele vai lecionar, também cadastramos o Estudante(Student) e informamos a turma(ClassSchool) e Escola(School) após esses cadastros podemos iniciar o Diário de Classe(ClassDiary) onde informamos o Estudante(Student) a data do dia da aula e o status de presença - PST, FTJ ou FNJ.

Os CRUDs são:
- School; 
- ClassSchool; 
- Student;
- Teacher; 
- ClassDiary;

### Relatórios Customizados Utilizando Query Native
Foi criado dois relatórios onde podemos obter informações mais precisas
- 1° Podemos listar todas as turmas(Class) de uma determinada Escola(School) só digitando parte do nome da Escola(School);
![Web 1](https://github.com/Muriloabreu/db-assets/blob/main/acompanha-Aluno/QueryNative_JoinClassSchool.png)
- 2° Podemos listar o status do diário de classe(Class Diary) de todos os Alunos(Students) informando a data e a Escola(School)
![Web 1](https://github.com/Muriloabreu/db-assets/blob/main/acompanha-Aluno/QueryNative_JoinDiaryClass.png)

# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot


## Passos para necessários para Implantação em produção

- Banco de dados: Postgres 9.5

## No Back end
- Pré-requisitos: Java 17

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>School</h5>

```json
{
        "id": 1,
        "name": "Escola Municipal Cidade Sul",
        "cnpj": "000.000.0020-20",
        "city": "Recife"
    },
    {
        "id": 2,
        "name": "Escola Estadual 01",
        "cnpj": "000.000.0006-10",
        "city": "Escada"
    }
```
</p>
<h5>ClassSchool</h5>

```json
{
        "id": 52,
        "name": "Infantil V",
        "category": "EDUCAÇÃO INFANTIL",
        "school": {
                  "id": 1,
                  "name": "Escola Municipal Cidade Sul",
                  "cnpj": "000.000.0020-20",
                  "city": "Recife"
        }
    },
    {
        "id": 53,
        "name": "Infantil IV",
        "category": "EDUCAÇÃO INFANTIL",
        "school": {
            "id": 2,
            "name": "Escola Estadual 01",
            "cnpj": "000.000.0006-10",
            "city": "Escada"
        }
    }
```
</p>
<h5>Teacher</h5>

```json
{
        "id": 1,
        "name": "Professor 01",
        "cpf": "000.000.0002-11",
        "email": "prof.01@teste.com",
        "senha": "123456",
        "classSchools": [
            {
                "id": 52,
                "name": "Infantil V",
                "category": "EDUCAÇÃO INFANTIL",
                "school": {
                           "id": 1,
                           "name": "Escola Municipal Cidade Sul",
                           "cnpj": "000.000.0020-20",
                           "city": "Recife"
                          }
           }]      
}
```
</p>
</p>

<h5>Student</h5>

```json
{
        "id": 102,
        "firtsName": "Aluno 02",
        "lastName": "sobrenome 02",
        "cpf": "000.000.003-02",
        "ages": "3",
        "responsibleName": "Responsavel 02",
        "registrationDate": "2023-06-09T18:38:59.264368",
        "classSchool": {
                      "id": 52,
                      "name": "Infantil V",
                      "category": "EDUCAÇÃO INFANTIL",
                      "school": {
                                 "id": 1,
                                 "name": "Escola Municipal Cidade Sul",
                                 "cnpj": "000.000.0020-20",
                                 "city": "Recife"
                                }
                       }
    }
```
</p>
</p>
<h5>Class Diary </h5>

```json
{
        "id": 5,
        "student": {
        "id": 102,
        "firtsName": "Aluno 02",
        "lastName": "sobrenome 02",
        "cpf": "000.000.003-02",
        "ages": "3",
        "responsibleName": "Responsavel 02",
        "registrationDate": "2023-06-09T18:38:59.264368",
        "classSchool": {
                      "id": 52,
                      "name": "Infantil V",
                      "category": "EDUCAÇÃO INFANTIL",
                      "school": {
                                 "id": 1,
                                 "name": "Escola Municipal Cidade Sul",
                                 "cnpj": "000.000.0020-20",
                                 "city": "Recife"
                                }
                       }
    },
        "date": "2023-06-09",
        "note": "FTJ"
    }
```
</p>
</p>

- Baixar o projeto

```bash
# clonar repositório
git clone git@github.com:Muriloabreu/acompanha-aluno.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu/
