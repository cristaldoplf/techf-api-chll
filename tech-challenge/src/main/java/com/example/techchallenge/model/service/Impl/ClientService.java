package com.example.techchallenge.model.service.Impl;

import com.example.techchallenge.exceptions.ResourceNotFoundException;
import com.example.techchallenge.model.dto.ClientDto;
import com.example.techchallenge.model.entity.Client;
import com.example.techchallenge.model.repository.IClientRepository;
import com.example.techchallenge.model.service.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService implements IClientService {

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ClientDto findById(Integer id) throws ResourceNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return modelMapper.map(client, ClientDto.class);
        }
        throw new ResourceNotFoundException("The client with ID: " + id + " does not exist");
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client clientResponse = clientRepository.save(modelMapper.map(clientDto, Client.class));
        ClientDto clientResponseDto = modelMapper.map(clientResponse, ClientDto.class);
        return clientResponseDto;
    }

    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent()) {
            throw new ResourceNotFoundException("The client with ID " + id + " that you want delete does not exists.");
        } else {
            client.get().setLayDown(true);
            update(modelMapper.map(client, ClientDto.class));
        }
    }

    @Override
    public void activeById(Integer id) throws ResourceNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent()) {
            throw new ResourceNotFoundException("The client with ID " + id + " that you want recover does not exists.");
        } else {
            client.get().setLayDown(false);
            update(modelMapper.map(client, ClientDto.class));
        }
    }

    @Override
    public ClientDto update(ClientDto clientDto) throws ResourceNotFoundException {
        Client client = modelMapper.map(clientDto, Client.class);
        if (clientRepository.existsById(client.getId())) {
            return modelMapper.map(clientRepository.save(client), ClientDto.class);
        }
        throw new ResourceNotFoundException("The client with ID " + client.getId() + " that you want update does not exists.");
    }

    @Override
    public Set<ClientDto> findAll() {
        List<Client> clientList = clientRepository.findAll();
        Set<ClientDto> clientDtos = new HashSet<>();
        for (Client cli : clientList) {
            clientDtos.add(modelMapper.map(cli, ClientDto.class));
        }
        return clientDtos;
    }
}
