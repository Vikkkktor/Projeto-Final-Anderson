function handlelogin(event){
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    const dadosLogin = {
        email: email,
        senha: senha
    };

}

function handleCadastroUsuario(event){
    event.preventDefault();
    const nome = document.getElementById('nome').value;
    const sobrenome = document.getElementById('sobrenome').value;
    const cpf = document.getElementById('CPF').value;
    const emailInput = document.getElementById('emailCadastro').value;
    const emailConfirm = document.getElementById('emailConfirmadoCadastro').value

    let email = ''
    if(emailInput && emailInput){
        if (emailInput === emailConfirm ){
            email = emailInput;
        }
    }

    const senhaInput = document.getElementById('senhaCadastro').value;
    const senhaConfirm = document.getElementById('senhaConfirmadaCadastro').value;

    let senha = ''
    if(senhaInput && senhaConfirm){
        if (senhaInput === senhaConfirm){
            senha = senhaInput;
        }
    }

    const dataNascimento = document.getElementById('dataNascimento').value;
    const telefone = document.getElementById('telefone').value;
    const cep = document.getElementById('CEP').value;
    const estado = document.getElementById('selecionarEstado').value;
    const cidade = document.getElementById('cidade').value
    const logradouro = document.getElementById('logradouro').value;
    const complemento = document.getElementById('complemento').value;

    const dadosCadastro = {
        nome: nome,
        sobrenome: sobrenome,
        cpf: cpf,
        email: email,
        senha: senha,
        dataNascimento: dataNascimento,
        telefone: telefone,
        cep: cep,
        estado: estado, 
        cidade: cidade,
        logradouro: logradouro,
        complemento: complemento
    };
}

function handleCadastroAnimal(event){
    event.preventDefault();
    const nome = document.getElementById('nomeAnimal').value;
    const especie = document.getElementById('especie').value;
    const sexo = document.getElementById('sexo').value;
    const porte = document.getElementById('porte').value;
    const idade = document.getElementById('idade').value
    const raca = document.getElementById('raca').value;
    const castrado = document.getElementById('castrado').value
    const descricao = document.getElementById('descricaoAnimal').value;
    const fotos = document.getElementById('uploadFoto').value

    const dadosCadastro = {
        nome: nome,
        especie: especie,
        sexo: sexo,
        porte: porte,
        idade: idade,
        raca: raca,
        castrado: castrado,
        descricao: descricao,
        fotos: fotos
    };
}

