<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Projeto Programação Avançada: SGM - Sistema Gestor de Funcionários e Impressora</h1>
<h4><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Tecnologias Usadas: </h3>

<ul>
  <li>
    <p>JDBC</p>
  </li>
  <li>
    <p>MYSql</p>
  </li>
  <li>
    <p>Netbeans - Java</p>
  </li>
</ul>

<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Especificações do projeto: </h3>
<ul>
  <li>
    <p>Projeto feito para cadeira de Programação Avançada - Faculdade Nova Roma</p>
  </li>
  <li>
    <p>Este projeto tem finalidade de ser complemento ao  <a href="https://github.com/gustavomeloGH/Projeto-Utilizando-Threads-Impressora-Concorrencia" target="_blank">Projeto Utilizando - Threads Impressora Concorrencia</a></p>
  </li>
  <li>
    <p>O sistema serve para realizar através do banco MySql - impressora_database, operações envolvendo CRUD,
    simular impressão de arquivos, além de gerar relatórios PDF de históricos destes dados.</p>
  </li>
</ul>

<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Como funciona? </h3>
<ul>
  <li>
    <p>Para utilizar o sistema, é necessário instalar os pluggins na biblioteca do Netbeans: 
    <ul>
     <li>
      <a href="https://sourceforge.net/projects/itext/files/iText/iText5.0.5/iText-5.0.5.jar/download" target="_blank">ITextPluggin 
      - Versão iText-5.0.5 </a> 
     </li>
     <li>
      <a href="https://dev.mysql.com/downloads/connector/j/" target="_blank">ITextPluggin 
      - MySql Connector - 5.1.45 </a> 
     </li>
    </ul>
    </p>
    <p>O sistema possui acesso gerencial, com as funcionalidades CRUD para os funcionários cadastrados e 
    o acesso de funcionários para utilizar o Recurso de Impressora (Simulação), ambos são abertos automaticamente
    pelas credenciais passadas na tela de Login.</p>
    <p>
      Para realizar o login, é necessário passar o número de Matrícula de um funcionário cadastrado e 
      a senha que é o Cpf desse funcionário. Para isto, você pode utilizar 94233, 60419852794 para acesso gerencial 
      (obs:. na documentação tem os demais dados já cadastrados para testes).
    </p>
    <p>Na tela de gerenciamento - SGM, navegue e utilize as demais funcionalidades. 
    Todos os dados são gerados a partir do banco de dados.</p>
    <p>A parte de impressora, é uma simulação que deverá futuramente rodar em paralelo com o projeto citado acima, 
        no projeto atual, apenas os arquivos da pasta são "imprimidos" (removidos) e adicionado os dados de impressão na 
        tabela específica para gerar Relatórios.
    </p>
  </li>
</ul>

<h3><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"></svg></a>Atenção: </h3>
<ul>
  <li>
    <p>Sempre abrir o sistema pela tela de login, pois necessário que seja registrado o Funcionário que fez o login.</p>
  </li>
  <li>
    <p>Instalar todos os pluggins citados acima para ter o funcionámento dos dados.</p>
  </li>
  <li>
    <p>Colocado na pasta Documentação, deste projeto, todos os dados utilizados, assim como os modelos relacionais, 
    dicionário de dados, os dados utilizados e todo comando MySql utilizado.</p>
  </li>
</ul>
