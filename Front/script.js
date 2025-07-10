async function handleLogin(event){
    event.preventDefault();

    const email = document.getElementById('emailLogin').value;
    const senha = document.getElementById('senhaLogin').value;

    // JSON LOGIN USUARIO
    const dadosLogin = {
        email: email,
        senha: senha
    };

    try{
        const response = await fetch ('http://localhost:8080/ ',{
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },

            body: JSON.stringify(dadosLogin)
    });
        const resultBack = await response.text();

        if (response.ok){
            alert('Login confirmado! Mensagem do server: ' + resultBack);
            window.location.href = '/index.html';
        }
        else{
            alert('Erro ao realizar login! Mensagem do  server: ' + (resultBack || 'erro ao conectar ao servidor'));
        }
    }
    catch (error){
        console.error('Erro na comunicação com o servidor!', error);
        alert('não foi possível comunicar com o servidor!');
    }
}

async function handleCadastroUsuario(event){
    event.preventDefault();
    const nome = document.getElementById('nome').value;
    const sobrenome = document.getElementById('sobrenome').value;
    const cpf = document.getElementById('CPF').value;
    const emailInput = document.getElementById('emailCadastro').value;
    const emailConfirm = document.getElementById('emailConfirmadoCadastro').value;

    let email = ''
    if(emailInput && emailConfirm){
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
    const cidade = document.getElementById('cidade').value;
    const logradouro = document.getElementById('logradouro').value;
    const complemento = document.getElementById('complemento').value;

    // JSON CADASTRO USUARIO
    const dadosCadastroUser = {
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

    try {
        const response = await fetch('http://localhost:8080/Adotantes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosCadastroUser)
        });
        
        const resultBack = await response.text();

        if (response.ok){
            alert('Usuário cadastrado com sucesso! Mensagem do server: ' + resultBack);
            window.location.href = '/login.html';
        }
        else{
            alert('Erro ao cadastrar usuário! Mensagem do  server: ' + (resultBack || 'erro ao conectar ao servidor'));
        }
    }
    catch (error){
        console.error('Erro na comunicação com o servidor!', error);
        alert('não foi possível comunicar com o servidor!');
    }
}

async function handleCadastroAnimal(event){
    event.preventDefault();
    const nome = document.getElementById('nomeAnimal').value;
    const especie = document.getElementById('especie').value;
    const sexo = document.getElementById('sexo').value;
    const porte = document.getElementById('porte').value;
    const idade = document.getElementById('idade').value;
    const raca = document.getElementById('raca').value;
    const castrado = document.getElementById('castrado').value;
    const descricao = document.getElementById('descricaoAnimal').value;
    const fotos = document.getElementById('uploadFoto').value;

    // JSON CADASTRO ANIMAL
    const dadosCadastroAnimal = {
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

    try{
        const response = await fetch('http://localhost:8080/Animais', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosCadastroAnimal)
        });

        const resultBack = await response.text();

        if(response.ok){
            alert("Animal cadastrado com sucesso! mensagem do servidor: " + resultBack);
            window.location.href = '/index.html';
        }
        else{
            alert('Erro ao cadastrar animal! mensagem do servidor: ' + (resultBack || 'erro ao se comunicar com o servidor'))
        }
    }
    catch(error){
        console.error('Erro na comunicação com o servidor ', error);
        alert('Não foi possível comunicar com o servidor')
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const botaoCadastroUser = document.getElementById('botaoCadastrar');
    const botaoCadastroAnimal = document.getElementById('botaoCadastrarAnimal');
    const botaoLogin = document.getElementById('botaoLogar');

    const loginForm = document.getElementById('fomularioLogin'); 
    const cadastroUsuarioForm = document.getElementById('fomularioCadastro'); 
    const cadastroAnimalForm = document.getElementById('fomularioCadastroAnimal'); 

    if (botaoCadastroUser) {
        botaoCadastroUser.addEventListener('click', function(event){
            handleCadastroUsuario(event);
        });
    }

    if (botaoCadastroAnimal) {
        botaoCadastroAnimal.addEventListener('click', function(event){
            handleCadastroAnimal(event);
        });
    }

    if (botaoLogin) {
        botaoLogin.addEventListener('click', function(event){
            handleLogin(event);
        });
    }
});

