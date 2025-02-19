﻿using System;
using System.Collections.Generic;
using System.Text;
using Core.Utilities.Results;

namespace Core.Utilities.Results
{
    public class SuccessDataResult<TData> : DataResult<TData> 
    {

        public SuccessDataResult(TData data) : base(true, data)
        {
            
        }
        public SuccessDataResult(TData data, string message) : base(true, message, data)
        {

        }
    }
}
