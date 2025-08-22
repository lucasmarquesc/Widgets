# Exemplos de Widgets Android - Programação para Dispositivos Móveis

### Universidade Federal de Rondônia (UNIR) - Curso de Ciência da Computação
**Disciplina:** Programação para Dispositivos Móveis  
**Professor:** Dr. Lucas Marques da Cunha

---

## 🎯 Sobre o Projeto

Este repositório contém o código-fonte desenvolvido em aula para demonstrar o uso e a manipulação dos principais componentes de interface (Widgets) do Android. O projeto serve como um guia prático e um laboratório para estudantes da disciplina, abordando desde elementos básicos de texto e botões até componentes mais complexos como barras de progresso e listas suspensas.

---

## 🛠️ Widgets e Componentes Abordados

O código no arquivo `MainActivity.java` demonstra a implementação e manipulação dos seguintes componentes:

* **`TextView`**: Exibição e alteração de texto dinamicamente através de um `Button`.
* **`EditText`**: Captura de texto inserido pelo usuário e exibição em um `Toast`.
* **`RadioGroup` e `RadioButton`**: Seleção de opções únicas, com exemplos de captura do valor tanto por um `Button` quanto por um `Listener` (`setOnCheckedChangeListener`).
* **`CheckBox`**: Seleção de múltiplas opções, demonstrando a verificação dos itens selecionados com um `Button` e a interação entre eles usando um `Listener` (`setOnCheckedChangeListener`).
* **`Spinner`**: Implementação de uma lista de opções suspensa (dropdown) e captura do item selecionado.
* **`ProgressBar`**:
    * **Determinado:** Simulação de um progresso de 0 a 100% usando `Thread` e `Handler` para atualizar a UI.
    * **Indeterminado:** Exibição de um "loading" infinito que desaparece após um tempo determinado, simulando o carregamento de um recurso.
* **`AutoCompleteTextView`**: Campo de texto que oferece sugestões de preenchimento automático a partir de uma lista pré-definida.
* **`RatingBar`**: Sistema de avaliação por estrelas, capturando a nota selecionada pelo usuário.
* **`ImageView`**: Exibição de imagens e alteração da imagem exibida através de um clique de botão.
* **`TextInputEditText`**: Componente de entrada de texto do Material Design para uma melhor experiência do usuário.

---

## 🚀 Como Executar o Projeto

Para executar este projeto, siga os passos abaixo:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
    ```
2.  **Abra no Android Studio:**
    * Inicie o Android Studio.
    * Selecione "Open an existing project" e navegue até a pasta do projeto clonado.
3.  **Sincronize o Gradle:**
    * Aguarde o Android Studio sincronizar e construir o projeto automaticamente.
4.  **Execute o App:**
    * Selecione um emulador ou conecte um dispositivo físico.
    * Clique no botão "Run" (▶️) para compilar e instalar o aplicativo.

---

## 📂 Estrutura do Código

Para fins didáticos, todo o código de manipulação dos componentes está centralizado no arquivo **`MainActivity.java`**. O layout correspondente, com todos os widgets declarados, pode ser encontrado em **`app/src/main/res/layout/activity_main.xml`**.
<img width="433" height="902" alt="image" src="https://github.com/user-attachments/assets/03c6d48b-af6d-417b-a203-037fcb4f6b00" />

