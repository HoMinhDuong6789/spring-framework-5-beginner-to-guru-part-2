package com.udemy.springmvcdemo.services;

import com.udemy.springmvcdemo.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUnits();
}
