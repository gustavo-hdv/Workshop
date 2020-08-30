/*
    This file is part of Workshop.

    Workshop is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Workshop is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Workshop. If not, see <https://www.gnu.org/licenses/>

    Contact me:
        Email:   gustavohenrique0008@gmail.com
        Discord: TwoSouls#3428
*/
package model.util;

import java.math.BigDecimal;
import java.util.List;
import model.bean.Cliente;
import model.bean.Config;
import model.bean.Funcionario;
import model.bean.Produto;
import model.bean.Servico;
import model.bean.Veiculo;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class Util {
    public static void validaString(String atributo, String msg) {
        if (atributo == null || atributo.trim().equals("")) {
            throw new NullPointerException(msg);
        }
    }
    public static void validaCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("Valor de código inválido" + codigo);
        }
    }
    public static void validaCliente(Cliente cliente) {
        if (cliente == null) {
            throw new NullPointerException("Cliente inválido");
        }
    }
    public static void validaFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new NullPointerException("Funcionario inválido");
        }
    }
    public static void validaServico(Servico servico) {
        if (servico == null) {
            throw new NullPointerException("Servico inválido");
        }
    }
    public static void validaProduto(Produto produto) {
        if (produto == null) {
            throw new NullPointerException("Produto inválido");
        }
    }
    public static void validaEmpresa(Config empresa) {
        if (empresa == null) {
            throw new NullPointerException("Empresa inválido");
        }
    }
    
    public static void validaValorUnitarioPS(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new IllegalArgumentException("Valor unitário não pode ser negativo ou nulo");
        }
        String unit = String.format("%,.2f", valorUnitario);
        if (unit.length() > 10) {
            throw new IllegalArgumentException("Valor unitário muito grande");
        }
    }
    
    public static void validaValorUnitarioPS(BigDecimal valorUnitario) {
        if (valorUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor unitário não pode ser negativo ou nulo");
        }
        String unit = String.format("%,.2f", valorUnitario);
        if (unit.length() > 10) {
            throw new IllegalArgumentException("Valor unitário muito grande");
        }
    }
    
//    public static void validaValorTotalPS(double valorTotal) {
//        if (valorTotal <= 0) {
//            throw new IllegalArgumentException("Valor total não pode ser negativo ou nulo");
//        }
//        String unit = String.format("%,.2f", valorTotal);
//        if (unit.length() > 14) {
//            throw new IllegalArgumentException("Valor total muito grande");
//        }
//    }
//    
//    public static void validaValorTotalPS(BigDecimal valorTotal) {
//        if (valorTotal.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("Valor total não pode ser negativo ou nulo");
//        }
//        String unit = String.format("%,.2f", valorTotal);
//        if (unit.length() > 13) {
//            throw new IllegalArgumentException("Valor total muito grande");
//        }
//    }
    
    public static void validaArrayString(List<String> array) {
        array.forEach((valor) -> {
            validaString(valor, "Atributo não pode ser nulo ou vazio");
        });
    }

    public static void validaArrayProdutos(List<Produto> produtos) {
        produtos.forEach((produto) -> {
            if (produto == null) {
                throw new NullPointerException();
            }
        });
    }
    
    public static void validaArrayServicos(List<Servico> servicos) {
        servicos.forEach((servico) -> {
            if (servico == null) {
                throw new NullPointerException();
            }
        });
    }
    
    public static void validaQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa ou nula");
        } else if (quantidade > 999) {
            throw new IllegalArgumentException("Quantidade não pode ser maior que 999");
        }
    }

    public static void validaVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new NullPointerException("Veículo inválido");
        }
    }
    
    public static void validaDescricaoPS(String descricao) {
        if (descricao.length() > 66) {
            throw new IllegalArgumentException("Descrição não pode passar de 66 caracteres");
        }
    }
    
    public static void validaDefeitosAndObservacoes(String defeitosAndObservacoes) {
        if (defeitosAndObservacoes.length() > 122) {
            throw new IllegalArgumentException("Defeitos/Observações muito grande");
        }
    }

    public static void validaNome(String nome) {
        if (nome.length() > 63) {
            throw new IllegalArgumentException("O máximo de caracteres para nome é 63");
        }
    }
    
    public static void validaFormaPagamento(String formaPagamento) {
        if (formaPagamento.length() > 20) {
            throw new IllegalArgumentException("O máximo de caracteres para nome é 20");
        }
    }
    
    public static void validaEndereco(String endereco) {
        if (endereco.length() > 72) {
            throw new IllegalArgumentException("O máximo de caracteres para endereço é 72");
        }
    }
    
    public static void validaTelefone(String telefone) {
        if (telefone.length() > 20) {
            throw new IllegalArgumentException("O máximo de caracteres para telefone é 20");
        }
    }
    
    public static void validaEmail(String email) {
        if (email.length() > 48) {
            throw new IllegalArgumentException("O máximo de caracteres para email é 48");
        }
    }
    
    public static void validaPlacaVeiculo(String placa) {
        if (placa.length() > 15) {
            throw new IllegalArgumentException("O máximo de caracteres para placa é 15");
        }
    }
    
    public static void validaDescricaoVeiculo(String descricao) {
        if (descricao.length() > 74) {
            throw new IllegalArgumentException("O máximo de caracteres para veículo é 74");
        }
    }
    
    public static void validaQuilometragemVeiculo(String quilometragem) {
        if (quilometragem.length() > 9) {
            throw new IllegalArgumentException("O máximo de caracteres para quilometragem é 9");
        }
    }
    
    public static void validaCombustivelVeiculo(String combustivel) {
        if (combustivel.length() > 17) {
            throw new IllegalArgumentException("O máximo de caracteres para combustível é 17");
        }
    }
    
    public static void validaMarcadorVeiculo(String marcador) {
        if (marcador.length() > 9) {
            throw new IllegalArgumentException("O máximo de caracteres para marcador é 9");
        }
    }
    
    public static void validaCorVeiculo(String cor) {
        if (cor.length() > 13) {
            throw new IllegalArgumentException("O máximo de caracteres para cor é 13");
        }
    }
}
