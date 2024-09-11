
## Principais Diferenças

- **QA (Quality Assurance)**: 
  Garante a qualidade do processo de desenvolvimento de software assegurando que todos os procedimentos e padrões sejam seguidos para evitar problemas no futuro.

- **Analista de Testes**: 
  Foca em validar e verificar o produto final completo ou em partes, identificando e relatando bugs para garantir o bom funcionamento do software.

## Funções Específicas
### QA
- **Definição de Processos**:
  Documenta e estabelece os procedimentos necessários para o desenvolvimento e teste, assegurando sua correta execução.
  - **Exemplo**: Criar um plano de qualidade com revisões de código, testes automatizados e auditorias regulares.
- **Verifica Qualidade**:
  Verifica se os processos estão sendo seguidos e se os padrões de qualidade estão sendo mantidos.
  
### Analista de Testes
- **Criação e Execução de Testes**:
  Desenvolve e executa testes para cada funcionalidade do sistema para identificar problemas e falhas.
  - **Exemplo**: Criar e testar funcionalidades do sistema de gerenciamento de leitos.
- **Reportar Defeitos**:
  Identifica e reporta quaisquer defeitos encontrados durante os testes.
  - **Exemplo**: Reportar um bug que impossibilita a atualização correta dos dados de um paciente no sistema.

## Exemplo em um Sistema de Gestão de Leitos
### QA
- **Planejamento de Qualidade**:
  Desenvolver um plano de qualidade com critérios de aceitação para o CRUD de pacientes, médicos, leitos e unidades de saúde. Também assegurar que os dados anonimizados estejam em conformidade com as leis de privacidade.
- **Auditoria de Processos**:
  Realizar auditorias para garantir que os desenvolvedores estão seguindo os processos definidos, como a anonimização de dados ao excluir registros.

### Analista de Testes
- **Desenvolvimento de Casos de Teste**:
  Criar casos de teste para funcionalidades do CRUD, como criar, salvar, atualizar e excluir unidades de saúde, médicos e pacientes.
- **Teste de Execução**:
  Realizar testes para garantir que os dados de um paciente sejam anonimizados corretamente ao serem excluídos, e também verificar se a contagem de leitos disponíveis é atualizada conforme necessário.
