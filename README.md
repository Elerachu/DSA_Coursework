# Algorithms Under the Microscope — Option A: Sorting

**Module:** Data Structures & Algorithms (COMS-RW-20515)
**Option chosen:** Option A — Sorting

## Overview

This repo implements and times two sorting algorithms written by hand (no built-in sorts):

- **Insertion Sort** — O(n²)
- **Merge Sort** — O(n log n)

Both are measured against random and (for insertion sort) already-sorted input across five sizes (500, 1,000, 2,000, 4,000, 8,000) and the results are compared against theoretical predictions in the accompanying written report.

## Structure

## Running

Each file has its own `main` method and can be run independently in IntelliJ (or via `javac`/`java` from the command line):

- Run `InsertionSort.java` / `MergeSort.java` to see a single sort demonstrated on a random array
- Run `InsertionSort_Test.java` / `MergeSort_Test.java` to run the correctness tests
- Run `InsertionSort_Timing.java` / `MergeSort_Timing.java` to reproduce the timing data writes to the CSV files above; timings will vary run to run as discussed in the report

## Report

The full written report has the predictions, measured results, doubling-test analysis and verdict; it is submitted separately as the assignment write-up.
