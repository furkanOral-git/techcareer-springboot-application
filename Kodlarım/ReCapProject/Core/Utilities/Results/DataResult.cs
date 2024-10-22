﻿using Core.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Core.Utilities.Results
{
    public class DataResult<TData> : Result, IDataResult<TData>
    {
        public TData Data { get; }

        public DataResult(bool success, string message, TData data) : base(success, message)
        {
            Data = data;
        }
        public DataResult(bool success, TData data) : base(success)
        {
            Data = data;
        }
    }
}
